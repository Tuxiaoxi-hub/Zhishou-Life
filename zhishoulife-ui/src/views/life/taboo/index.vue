<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="禁忌主题" prop="title">
        <el-input
          v-model="queryParams.title"
          placeholder="请输入搭配/禁忌主题"
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
          v-hasPermi="['life:taboo:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['life:taboo:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['life:taboo:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['life:taboo:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tabooList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="搭配/禁忌主题" align="center" prop="title" />
      <el-table-column label="状态" align="center" prop="status">
        <template #default="scope">
          <dict-tag :options="sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="View" @click="handleView(scope.row)">查看</el-button>
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['life:taboo:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['life:taboo:remove']">删除</el-button>
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

    <el-dialog :title="title" v-model="open" width="700px" append-to-body>
      <div v-if="isView" class="view-detail">
        <div class="view-item">
          <label>搭配/禁忌主题</label>
          <div class="text">{{ form.title }}</div>
        </div>
        <div class="view-item">
          <label>详细说明</label>
          <div class="text text-area">{{ form.content }}</div>
        </div>
        <div class="view-item">
          <label>不良影响</label>
          <div class="text text-area">{{ form.harm }}</div>
        </div>
        <div class="view-item">
          <label>合理建议</label>
          <div class="text text-area">{{ form.suggest }}</div>
        </div>
        <div class="view-item">
          <label>状态</label>
          <div class="text">
            <dict-tag :options="sys_normal_disable" :value="form.status"/>
          </div>
        </div>
      </div>

      <el-form v-else ref="tabooRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="搭配/禁忌主题" prop="title">
          <el-input v-model="form.title" placeholder="请输入搭配/禁忌主题" />
        </el-form-item>
        <el-form-item label="详细说明" prop="content">
          <el-input v-model="form.content" type="textarea" placeholder="请输入内容" :rows="4" />
        </el-form-item>
        <el-form-item label="不良影响" prop="harm">
          <el-input v-model="form.harm" type="textarea" placeholder="请输入内容" :rows="4" />
        </el-form-item>
        <el-form-item label="合理建议" prop="suggest">
          <el-input v-model="form.suggest" type="textarea" placeholder="请输入内容" :rows="4" />
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

<script setup name="Taboo">
import { listTaboo, getTaboo, delTaboo, addTaboo, updateTaboo } from "@/api/life/taboo"

const { proxy } = getCurrentInstance()
const { sys_normal_disable } = proxy.useDict('sys_normal_disable')

const tabooList = ref([])
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
    title: null,
    status: null
  },
  rules: {
    title: [{ required: true, message: "搭配/禁忌主题不能为空", trigger: "blur" }],
    content: [{ required: true, message: "详细说明不能为空", trigger: "blur" }]
  }
})

const { queryParams, form, rules } = toRefs(data)

/** 查询饮食禁忌与搭配列表 */
function getList() {
  loading.value = true
  listTaboo(queryParams.value).then(response => {
    tabooList.value = response.rows
    total.value = response.total
    loading.value = false
  })
}

// 取消按钮
function cancel() {
  open.value = false
  reset()
  isView.value = false
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    title: null,
    content: null,
    harm: null,
    suggest: null,
    status: null
  }
  proxy.resetForm("tabooRef")
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1
  getList()
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef")
  handleQuery()
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id)
  single.value = selection.length != 1
  multiple.value = !selection.length
}

/** 新增按钮操作 */
function handleAdd() {
  reset()
  isView.value = false
  open.value = true
  title.value = "添加饮食禁忌与搭配"
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset()
  isView.value = false
  const _id = row.id || ids.value
  getTaboo(_id).then(response => {
    form.value = response.data
    open.value = true
    title.value = "修改饮食禁忌与搭配"
  })
}

/** 查看按钮操作 */
function handleView(row) {
  reset()
  isView.value = true
  getTaboo(row.id).then(response => {
    form.value = response.data
    open.value = true
    title.value = "查看饮食禁忌与搭配"
  })
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["tabooRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateTaboo(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功")
          open.value = false
          getList()
        })
      } else {
        addTaboo(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功")
          open.value = false
          getList()
        })
      }
    }
  })
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value
  proxy.$modal.confirm('是否确认删除饮食禁忌与搭配编号为"' + _ids + '"的数据项？').then(function() {
    return delTaboo(_ids)
  }).then(() => {
    getList()
    proxy.$modal.msgSuccess("删除成功")
  }).catch(() => {})
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('life/taboo/export', {
    ...queryParams.value
  }, `taboo_${new Date().getTime()}.xlsx`)
}

getList()
</script>

<style scoped>
.view-detail {
  padding: 5px;
}
.view-item {
  margin-bottom: 20px;
}
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
  display: block;
}
</style>