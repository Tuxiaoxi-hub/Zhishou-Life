<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="菜品名称" prop="dishName">
        <el-input
          v-model="queryParams.dishName"
          placeholder="请输入菜品名称"
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
          v-hasPermi="['life:cook:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['life:cook:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['life:cook:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['life:cook:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="cookList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="菜品名称" align="center" prop="dishName" />
      <el-table-column label="状态" align="center" prop="status">
        <template #default="scope">
          <dict-tag :options="sys_normal_disable" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="View" @click="handleView(scope.row)">查看</el-button>
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['life:cook:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['life:cook:remove']">删除</el-button>
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
          <label>菜品名称</label>
          <div class="text">{{ form.dishName }}</div>
        </div>
        <div class="view-item">
          <label>菜品配图</label>
          <div class="text">
            <img :src="form.cover" style="max-width:200px;" v-if="form.cover">
            <span v-else>无图片</span>
          </div>
        </div>
        <div class="view-item">
          <label>食材配料</label>
          <div class="text text-area">{{ form.ingredient }}</div>
        </div>
        <div class="view-item">
          <label>烹饪步骤</label>
          <div class="text text-area">{{ form.step }}</div>
        </div>
        <div class="view-item">
          <label>烹饪技巧</label>
          <div class="text text-area">{{ form.skill }}</div>
        </div>
        <div class="view-item">
          <label>状态</label>
          <div class="text">
            <dict-tag :options="sys_normal_disable" :value="form.status"/>
          </div>
        </div>
      </div>

      <el-form v-else ref="cookRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="菜品名称" prop="dishName">
          <el-input v-model="form.dishName" placeholder="请输入菜品名称" />
        </el-form-item>
        <el-form-item label="菜品配图" prop="cover">
          <image-upload v-model="form.cover"/>
        </el-form-item>
        <el-form-item label="食材配料" prop="ingredient">
          <el-input v-model="form.ingredient" type="textarea" placeholder="请输入内容" :rows="4" />
        </el-form-item>
        <el-form-item label="烹饪步骤" prop="step">
          <el-input v-model="form.step" type="textarea" placeholder="请输入内容" :rows="6" />
        </el-form-item>
        <el-form-item label="烹饪技巧" prop="skill">
          <el-input v-model="form.skill" type="textarea" placeholder="请输入内容" :rows="4" />
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

<script setup name="Cook">
import { listCook, getCook, delCook, addCook, updateCook } from "@/api/life/cook"

const { proxy } = getCurrentInstance()
const { sys_normal_disable } = proxy.useDict('sys_normal_disable')

const cookList = ref([])
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
    dishName: null,
    status: null
  },
  rules: {
    dishName: [{ required: true, message: "菜品名称不能为空", trigger: "blur" }],
    ingredient: [{ required: true, message: "食材配料不能为空", trigger: "blur" }],
    step: [{ required: true, message: "烹饪步骤不能为空", trigger: "blur" }]
  }
})

const { queryParams, form, rules } = toRefs(data)

/** 查询家常菜烹饪列表 */
function getList() {
  loading.value = true
  listCook(queryParams.value).then(response => {
    cookList.value = response.rows
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
    dishName: null,
    cover: null,
    ingredient: null,
    step: null,
    skill: null,
    status: null
  }
  proxy.resetForm("cookRef")
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
  title.value = "添加家常菜烹饪"
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset()
  isView.value = false
  const _id = row.id || ids.value
  getCook(_id).then(response => {
    form.value = response.data
    open.value = true
    title.value = "修改家常菜烹饪"
  })
}

/** 查看按钮操作 */
function handleView(row) {
  reset()
  isView.value = true
  getCook(row.id).then(response => {
    form.value = response.data
    open.value = true
    title.value = "查看家常菜烹饪"
  })
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["cookRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateCook(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功")
          open.value = false
          getList()
        })
      } else {
        addCook(form.value).then(response => {
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
  proxy.$modal.confirm('是否确认删除家常菜烹饪编号为"' + _ids + '"的数据项？').then(function() {
    return delCook(_ids)
  }).then(() => {
    getList()
    proxy.$modal.msgSuccess("删除成功")
  }).catch(() => {})
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('life/cook/export', {
    ...queryParams.value
  }, `cook_${new Date().getTime()}.xlsx`)
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