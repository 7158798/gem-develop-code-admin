<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>工单列表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/biz/workOrder/list',
				method: 'POST',
				title : '',
				iconCls : '',
				fit : true,
				fitColumns : true,
				pagination : true,
				rownumbers:true,
				pageSize : 20,
				pageList : [ 10,20,30 ],
				nowarp : false,
				border : false,
				idField : 'subjectId',
				sortName : '',
				sortOrder : '',
				remotesort: true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'subjectId',
					hidden : true
				} ] ],
				columns : [ [ 
					{
						title : '工单ID',
						field : 'workId',
						width : 150,
						align : 'center'
					},
					{
						title : '工单主题',
						field : 'subject',
						width : 150,
						align : 'center'
					},
					{
						title : '工单类型',
						field : 'workType',
						width : 150,
						align : 'center',
						formatter: function(value,row,index){
							if (value == 1) {
								return "<font>充值</font>";
							}
							if (value == 2) {
								return "<font>提现</font>";
							}
							if (value == 3) {
								return "<font>申诉</font>";
							}
							if (value == 4) {
								return "<font>仲裁</font>";
							}
							if (value == 5) {
								return "<font>其他</font>";
							}
							return value;
						}
					},
					{
						title : '币种类型',
						field : 'currencyId',
						width : 150,
						align : 'center',
						formatter: function(value,row,index){
							if (value == 1) {
								return "<font>usdt</font>";
							}
							if (value == 2) {
								return "<font>eos</font>";
							}
							return value;
						}
					},
					{
						title : '业务编号',
						field : 'bizId',
						width : 150,
						align : 'center'
					},
					{
						title : '提交用户',
						field : 'uid',
						width : 150,
						align : 'center'
					},
					{
						title : '账户ID',
						field : 'accountId',
						width : 150,
						align : 'center'
					},
					{
						title : '手机号',
						field : 'phoneCode',
						width : 150,
						align : 'center'
					},
					{
						title : '用户名称',
						field : 'name',
						width : 150,
						align : 'center'
					},
					{
						title : '提交时间',
						field : 'submitTime',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value != null) {
								var currentDate = new Date(value);
								return currentDate.toLocaleDateString();
							}
							return value;
						}
					},
					{
						title : '处理客服编号',
						field : 'sysUid',
						width : 150,
						align : 'center'
					},
					{
						title : '客服名称',
						field : 'sysName',
						width : 150,
						align : 'center'
					},
					{
						title : '处理时间',
						field : 'finishedTime',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value != null) {
								var currentDate = new Date(value);
								return currentDate.toLocaleDateString();
							}
							return value;
						}
					},
					{
						title : '工单状态',
						field : 'workStatus',
						width : 150,
						align : 'center',
						formatter: function(value,row,index){
							if (value == 1) {
								return "<font>未处理</font>";
							}
							if (value == 2) {
								return "<font>处理中</font>";
							}
							if (value == 3) {
								return "<font>已处理</font>";
							}
							return value;
						}
					},
					{
						title : '创建时间',
						field : 'createTime',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value != null) {
								var currentDate = new Date(value);
								return currentDate.toLocaleDateString();
							}
							return value;
						}
					},
					{
						title : '更新时间',
						field : 'updatedTime',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value != null) {
								var currentDate = new Date(value);
								return currentDate.toLocaleDateString();
							}
							return value;
						}
					},
				{
					title : '操作',
					field : '_opt',
					align : 'center',
					width : 100,
					formatter:function (value, row, index){
                        var a = '';var b = '';var c = '';
                        var div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a>';
						<shiro:hasPermission name="biz:workOrder:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/biz/workOrder/info?id='+row.subjectId+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="biz:workOrder:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/biz/workOrder/toUpdate?id='+row.subjectId+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="biz:workOrder:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.subjectId+')"><i class="fa fa-trash-o"></i>删除</a></li>';
						</shiro:hasPermission>
                        div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a><ul class="u-menu">' + a + b + c + '</ul></div>';
            			return div;
					}
				}
				] ],
				onClickRow : function(rowIndex, rowData) {
				}
			}).datagrid('getPager').pagination({
				showPageList : true,
				showRefresh : true
			});
	  	});
	  	function reloadTable(){
	  		try{	
				$('#dataGrid').datagrid('reload');	
			}catch(ex){
			}
	  	}
  		function deleterow(id){
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/biz/workOrder/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/biz/workOrder/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/biz/workOrder/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>工单管理</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<shiro:hasPermission name="biz:workOrder:view">
		   			<span>业务编号:</span><input name="workOrderVO.bizId" />
		   			<span>账户ID:</span><input name="workOrderVO.accountId" />
		   			<span>手机号:</span><input name="workOrderVO.phoneCode" />
		   			<span>工单类型:</span>
		   			<select name = "workOrderVO.workType">
		   				<option value="">--请选择--</option>
		   				<option value="1">充值</option>
		   				<option value="2">提现</option>
		   				<option value="3">申诉</option>
		   				<option value="4">仲裁</option>
		   				<option value="5">其他</option>
		   			</select>
		   			<span>工单状态:</span>
		   			<select name = "workOrderVO.workStatus">
		   				<option value="">--请选择--</option>
		   				<option value="1">未处理</option>
		   				<option value="2">处理中</option>
		   				<option value="3">已处理</option>
		   			</select>
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="biz:workOrder:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
