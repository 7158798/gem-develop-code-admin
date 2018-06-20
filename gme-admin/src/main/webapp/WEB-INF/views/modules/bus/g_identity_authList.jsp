<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>身份认证列表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/bus/g_identity_auth/list',
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
				idField : 'auth_id',
				sortName : '',
				sortOrder : '',
				remotesort: true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'auth_id',
					hidden : true
				} ] ],
				columns : [ [ 
					{
						title : '用户编号',
						field : 'uid',
						width : 150,
						align : 'center'
					},
					{
						title : '真实姓名',
						field : 'real_name',
						width : 150,
						align : 'center'
					},
					{
						title : '证件类型',
						field : 'certificate_type',
						width : 150,
						align : 'center',
						formatter : function (value,row,index){
							if (value == "1") {
								return "<font>身份证</font>";
							}
							if (value == "2") {
								return "<font>护照</font>";
							}
							if (value == "3") {
								return "<font>军官证</font>";
							}
							if (value == "4") {
								return "<font>台湾居民通行证</font>";
							}
							if (value == "5") {
								return "<font>港澳居民通行证</font>";
							}
							return value;
						}
					},
					{
						title : '证件号码',
						field : 'certificate_number',
						width : 150,
						align : 'center'
					},
					{
						title : '是否是认证商家',
						field : 'is_auth_supplier',
						width : 150,
						align : 'center',
						formatter : function (value,row,index){
							if (value == "0") {
								return "<font>否</font>";
							}
							if (value == "1") {
								return "<font>是</font>";
							}
							return value;
						}
					},
					{
						title : '认证状态',
						field : 'auth_status',
						width : 150,
						align : 'center',
						formatter : function (value,row,index){
							if (value == "1") {
								return "<font>未认证</font>";
							}
							if (value == "2") {
								return "<font>认证中</font>";
							}
							if (value == "3") {
								return "<font>已通过认证</font>";
							}
							if (value == "4") {
								return "<font>未通过认证</font>";
							}
							return value;
						}
					},
					{
						title : '记录状态',
						field : 'status',
						width : 150,
						align : 'center',
						formatter : function (value,row,index){
							if (value == "0") {
								return "<font>正常</font>";
							}
							if (value == "1") {
								return "<font>异常</font>";
							}
							return value;
						}
					},
					{
						title : '创建时间',
						field : 'create_time',
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
						field : 'updated_time',
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
						<shiro:hasPermission name="bus:g_identity_auth:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/bus/g_identity_auth/info?id='+row.auth_id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_identity_auth:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/bus/g_identity_auth/toUpdate?id='+row.auth_id+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_identity_auth:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.auth_id+')"><i class="fa fa-trash-o"></i>删除</a></li>';
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
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/bus/g_identity_auth/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/bus/g_identity_auth/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/bus/g_identity_auth/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>身份认证管理</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<shiro:hasPermission name="bus:g_identity_auth:view">
		   			<span>真实姓名:</span><input name="g_identity_auth_vo.real_name" type="text"/>
		   			<span>证件类型:</span>
		   			<select name="g_identity_auth_vo.certificate_type">
		   				<option value="">--请选择--</option>
		   				<option value="1">身份证</option>
		   				<option value="2">护照</option>
		   				<option value="3">军官证</option>
		   				<option value="4">台湾居民通行证</option>
		   				<option value="5">港澳居民通行证</option>
		   			</select>
		   			<span>是否是商家:</span>
		   			<select name="g_identity_auth_vo.is_auth_supplier">
		   				<option value="">--请选择--</option>
		   				<option value="0">否</option>
		   				<option value="1">是</option>
		   			</select>
		   			<span>认证状态:</span>
		   			<select name="g_identity_auth_vo.auth_status">
		   				<option value="">--请选择--</option>
		   				<option value="1">未认证</option>
		   				<option value="2">认证中</option>
		   				<option value="3">已通过认证</option>
		   				<option value="4">未通过认证</option>
		   			</select>
		   			<span>记录状态:</span>
		   			<select name="g_identity_auth_vo.status">
		   				<option value="">--请选择--</option>
		   				<option value="0">正常</option>
		   				<option value="1">异常</option>
		   			</select>
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="bus:g_identity_auth:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
