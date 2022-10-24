<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="菜名" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入菜名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="次数" prop="doItNum">
        <el-input
          v-model="queryParams.doItNum"
          placeholder="请输入次数"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      
      <el-form-item label="评分5分制" prop="grade">
        <el-input
          v-model="queryParams.grade"
          placeholder="请输入评分5分制"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="点赞" prop="zan">
        <el-input
          v-model="queryParams.zan"
          placeholder="请输入点赞"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:eat:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:eat:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:eat:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:eat:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="eatList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="菜名" align="center" prop="name" />
      <el-table-column label="标签" align="center" prop="tagName" />
      <el-table-column label="展示图" align="center" prop="displayPicture" >
        <template slot-scope="scope">
          <el-image style="height: 100px" :src="scope.row.displayPicture" :preview-src-list="srcList" />
        </template>
      </el-table-column>

      <el-table-column label="小贴士" align="center" prop="tips" />
      <el-table-column label="评分" align="center" prop="grade" />
      <el-table-column label="点赞" align="center" prop="zan" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row,scope.index)"
            v-hasPermi="['monitor:operlog:query']"
          >详细</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:eat:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:eat:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改吃什么对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-steps :active="active" finish-status="success">
        <el-step title="步骤 1"></el-step>
        <el-step title="步骤 2"></el-step>
        <el-step title="步骤 3"></el-step>
      </el-steps>

      <div v-if="active == 0">
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
          <el-form-item label="菜名" prop="name">
            <el-input v-model="form.name" placeholder="请输入菜名" />
          </el-form-item>
      
          <el-form-item label="类型" prop="type">
            <el-select v-model="form.tag" placeholder="请选择类型" clearable>
              <el-option v-for="dict in tags" :key="dict.dictCode" :label="dict.dictLabel" :value="dict.dictCode" />
            </el-select>
          </el-form-item>
      
          <el-form-item label="描述" prop="description">
            <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
          </el-form-item>
          <el-form-item label="展示图" prop="displayPicture">
            <el-input v-model="form.displayPicture" type="textarea" placeholder="请输入内容" />
          </el-form-item>
          <el-form-item label="小贴士" prop="tips">
            <el-input v-model="form.tips" type="textarea" placeholder="请输入内容" />
          </el-form-item>
        </el-form>
      </div>

      <div v-if="active == 1">1111</div>
      <div v-if="active == 2">2222</div>

      <el-button style="margin-top: 12px;" v-if="active != step - 1" @click="next">下一步</el-button>
      <el-button style="margin-top: 12px;" v-if="active == step - 1" type="primary" @click="submitForm">完成</el-button>
    </el-dialog>

    <!-- 操作日志详细 -->
    <el-dialog :title= 'title' :visible.sync="openDetail" width="700px" append-to-body center>
      <el-form ref="detail" :model="detail" label-width="100px" size="mini">
        <el-row>
          <el-col :span="24">
            <el-form-item label="描述">{{ detail.description }}</el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="用料"></el-form-item>
          </el-col>

          <el-col :span="12" v-for="material in materials" :key='material.id'  :offset="1">
            <el-form-item :label=material.name>| &nbsp;&nbsp;&nbsp;{{material.dosage}}</el-form-item>
          </el-col>
          
          <div class="stepBeat">
            <el-col :span="24" v-for="stepBeat in stepBeats" :key="stepBeat.id" >
              <div style="font-size: 20px; font-weight:bold">步揍{{stepBeat.id}}</div> 
              <br/>
               <div size="5">{{stepBeat.content}}</div> 
              <el-image :src='stepBeat.imgs' :preview-src-list="srcList" />
            </el-col>
          </div>
        </el-row>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="openDetail = false">关 闭</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listEat, getEat, delEat, addEat, updateEat, dictData } from "@/api/system/eat";

export default {
  name: "Eat",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 吃什么表格数据
      eatList: [],
      stepBeats: [],
      materials: [],
      tags: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      openDetail: false,
      srcList: [
          'https://fuss10.elemecdn.com/8/27/f01c15bb73e1ef3793e64e6b7bbccjpeg.jpeg',
          'https://fuss10.elemecdn.com/1/8e/aeffeb4de74e2fde4bd74fc7b4486jpeg.jpeg'
        ],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        tag: null,
        doItNum: null,
        materialId: null,
        stepBeatId: null,
        description: null,
        displayPicture: null,
        tips: null,
        grade: null,
        zan: null,
        status: null,
      },
      // 表单参数
      form: {},
      detail: {},
      step: 3,
      active: 0,
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
    this.getDictData("tag");
  },
  methods: {
    /** 查询吃什么列表 */
    getList() {
      this.loading = true;
      listEat(this.queryParams).then(response => {
        this.eatList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    getDictData(dictType){
      dictData(dictType).then(response => {
        this.tags = response.rows;
        console.log("tags", this.tags);
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        tag: null,
        doItNum: null,
        materialId: null,
        stepBeatId: null,
        description: null,
        displayPicture: null,
        tips: null,
        grade: null,
        zan: null,
        status: "0",
        delFlag: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    next() {
        if (this.active++ > 2) this.active = 0;
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 详细按钮操作 */
    handleView(row) {
      this.openDetail = true;

      console.log("======= row", row);
      // getDetail row.id
      this.getDetail(row.id);

      this.detail = row;
    },
    getDetail(id){
      getEat(id).then(response => {
        this.detail = response.data;
        this.title = this.detail.name + ' 操作详情';
        this.materials = response.data.ldMaterials;
        this.stepBeats = response.data.ldStepBeats;

        console.log("======= materials", this.materials);
      });
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加吃什么";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getEat(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改吃什么";
      });
    },
    /** 提交按钮 */
    submitForm() {
      console.log("========= form", this.form);
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateEat(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addEat(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除吃什么编号为"' + ids + '"的数据项？').then(function() {
        return delEat(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/eat/export', {
        ...this.queryParams
      }, `eat_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>

<style rel="stylesheet/scss" lang="scss">
  .stepBeat{
    padding: 0 20px;
    margin: 0 auto;
    display: block;
  }

</style>
