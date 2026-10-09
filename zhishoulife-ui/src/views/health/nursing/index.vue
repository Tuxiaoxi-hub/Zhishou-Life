<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="病症名称" prop="diseaseName">
        <el-input
          v-model="queryParams.diseaseName"
          placeholder="请输入病症名称"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择状态" clearable>
          <el-option
            v-for="dict in sys_normal_disable"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['health:nursing:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['health:nursing:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['health:nursing:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['health:nursing:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="nursingList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="病症名称" align="center" prop="diseaseName" />
      <el-table-column label="状态" align="center" prop="status">
        <template #default="scope">
          <dict-tag :options="sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="View" @click="handleView(scope.row)">查看</el-button>
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['health:nursing:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['health:nursing:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改弹窗 -->
    <el-dialog :title="title" v-model="open" width="700px" append-to-body>
      <!-- 查看模式：纯文本展示 -->
      <div v-if="isView" class="view-detail">
        <div class="view-item">
          <label>病症名称</label>
          <div class="text">{{ form.diseaseName }}</div>
        </div>
        <div class="view-item">
          <label>护理方法</label>
          <div class="text text-area">{{ form.content }}</div>
        </div>
        <div class="view-item">
          <label>适用人群</label>
          <div class="text">{{ form.suitable }}</div>
        </div>
        <div class="view-item">
          <label>注意事项</label>
          <div class="text text-area">{{ form.attention }}</div>
        </div>
        <div class="view-item">
          <label>状态</label>
          <div class="text">
            <dict-tag :options="sys_normal_disable" :value="form.status"/>
          </div>
        </div>
      </div>

      <!-- 编辑模式：原表单 -->
      <el-form v-else ref="nursingRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="病症名称" prop="diseaseName">
          <el-input v-model="form.diseaseName" placeholder="请输入病症名称" />
        </el-form-item>
        <el-form-item label="护理方法" prop="content">
          <el-input v-model="form.content" type="textarea" placeholder="请输入内容" :rows="6" />
        </el-form-item>
        <el-form-item label="适用人群" prop="suitable">
          <el-input v-model="form.suitable" placeholder="请输入适用人群" />
        </el-form-item>
        <el-form-item label="注意事项" prop="attention">
          <el-input v-model="form.attention" type="textarea" placeholder="请输入内容" :rows="6" />
        </el-form-item>
        <el-form-item label="状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in sys_normal_disable"
              :key="dict.value"
              :label="parseInt(dict.value)"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>

      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" v-show="!isView" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">{{ isView ? '关 闭' : '取 消' }}</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Nursing">
import { listNursing, getNursing, delNursing, addNursing, updateNursing } from "@/api/health/nursing"

const { proxy } = getCurrentInstance()
const { sys_normal_disable } = proxy.useDict('sys_normal_disable')

const nursingList = ref([])
const open = ref(false)
const loading = ref(true)
const showSearch = ref(true)
const ids = ref([])
const single = ref(true)
const multiple = ref(true)
const total = ref(0)
const title = ref("")
const isView = ref(false)

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    diseaseName: null,
    status: null
  },
  rules: {
    diseaseName: [{ required: true, message: "病症名称不能为空", trigger: "blur" }],
    content: [{ required: true, message: "护理方法不能为空", trigger: "blur" }],
    suitable: [{ required: true, message: "适用人群不能为空", trigger: "blur" }],
    attention: [{ required: true, message: "注意事项不能为空", trigger: "blur" }],
    status: [{ required: true, message: "状态不能为空", trigger: "change" }]
  }
})

const { queryParams, form, rules } = toRefs(data)

// 查询列表
function getList() {
  loading.value = true
  listNursing(queryParams.value).then(res => {
    nursingList.value = res.rows
    total.value = res.total
    loading.value = false
  })
}

// 关闭
function cancel() {
  open.value = false
  reset()
  isView.value = false
}

// 重置
function reset() {
  form.value = { id: null, diseaseName: null, content: null, suitable: null, attention: null, status: null }
  proxy.resetForm("nursingRef")
}

// 搜索、重置
function handleQuery() { queryParams.value.pageNum = 1; getList() }
function resetQuery() { proxy.resetForm("queryRef"); handleQuery() }

// 多选
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id)
  single.value = selection.length != 1
  multiple.value = !selection.length
}

// 新增
function handleAdd() {
  reset()
  isView.value = false
  open.value = true
  title.value = "添加常见病症护理"
}

// 修改
function handleUpdate(row) {
  reset()
  isView.value = false
  const id = row.id || ids.value
  getNursing(id).then(res => {
    form.value = res.data
    open.value = true
    title.value = "修改常见病症护理"
  })
}

// 查看
function handleView(row) {
  reset()
  isView.value = true
  getNursing(row.id).then(res => {
    form.value = res.data
    open.value = true
    title.value = "查看常见病症护理"
  })
}

// 提交
function submitForm() {
  proxy.$refs["nursingRef"].validate(valid => {
    if (valid) {
      const api = form.value.id ? updateNursing : addNursing
      api(form.value).then(() => {
        proxy.$modal.msgSuccess(form.value.id ? "修改成功" : "新增成功")
        open.value = false
        getList()
      })
    }
  })
}

// 删除
function handleDelete(row) {
  const ids = row.id || ids.value
  proxy.$modal.confirm('是否确认删除编号为"' + ids + '"的数据项？').then(() => {
    return delNursing(ids)
  }).then(() => {
    getList()
    proxy.$modal.msgSuccess("删除成功")
  })
}

// 导出
function handleExport() {
  proxy.download('health/nursing/export', {...queryParams.value}, `nursing_${new Date().getTime()}.xlsx`)
}

getList()
</script>

<style scoped>
/* 查看详情样式 */
.view-detail {
  padding: 5px;
}
.view-item {
  margin-bottom: 20px;
}
/* 字段名统一颜色：主题蓝，柔和醒目 */
.view-item label {
  font-size: 14px;
  font-weight: 500;
  color: #1877FF;
  display: block;
  margin-bottom: 8px;
}
.text {
  font-size: 14px;
  color: #333;
  line-height: 1.6;
  padding: 0 5px;
  min-height: 32px;
  display: flex;
  align-items: center;
}
.text-area {
  padding: 10px 5px;
  white-space: pre-wrap;
  word-wrap: break-word;
  line-height: 1.8;
  min-height: 120px;
}
</style>