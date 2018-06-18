<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>资产信息列表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/bus/g_asset/list',
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
				idField : 'asset_id',
				sortName : '',
				sortOrder : '',
				remotesort: true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'asset_id',
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
						title : '账号ID',
						field : 'account_id',
						width : 150,
						align : 'center'
					},
					{
						title : '币种',
						field : 'currency_id',
						width : 150,
						align : 'center'
					},
					{
						title : '总资产',
						field : 'total_assets',
						width : 150,
						align : 'center'
					},
					{
						title : '可用资产',
						field : 'usable_assets',
						width : 150,
						align : 'center'
					},
					{
						title : '冻结资产',
						field : 'frozen_assets',
						width : 150,
						align : 'center'
					},
					{
						title : '资产状态',
						field : 'status',
						width : 150,
						align : 'center',
						formatter : function (value,row,index){
							if (value == 0) {
								return "<font>正常</font>";
							}
							if (value == 1) {
								return "<font>冻结</font>";
							}
							return value;
						}
					},
					{
						title : '备注',
						field : 'remark',
						width : 150,
						align : 'center'
					},
					{
						title : '创建时间',
						field : 'create_time',
						width : 150,
						align : 'center'
					},
					{
						title : '更新时间',
						field : 'updated_time',
						width : 150,
						align : 'center'
					},
				{
					title : '操作',
					field : '_opt',
					align : 'center',
					width : 100,
					formatter:function (value, row, index){
                        var a = '';var b = '';var c = '';
                        var div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a>';
                        <%--<shiro:hasPermission name="bus:g_asset:view">--%>
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/bus/g_asset/info?id='+row.asset_id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						<%--</shiro:hasPermission> */--%>
						<%--<shiro:hasPermission name="bus:g_asset:update"> */--%>
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/bus/g_asset/toUpdate?id='+row.asset_id+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						<%--</shiro:hasPermission> */--%>
						<shiro:hasPermission name="bus:g_asset:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.asset_id+')"><i class="fa fa-trash-o"></i>删除</a></li>';
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
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/bus/g_asset/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/bus/g_asset/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/bus/g_asset/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>资产信息管理</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<%-- <shiro:hasPermission name="bus:g_asset:view"> --%>
		   			<span>资产状态:</span>
		   			<select name="g_asset_vo.status">
		   				<option value="">--请选择--</option>
		   				<option value="0">正常</option>
		   				<option value="1">冻结</option>
		   			</select>
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			<%-- </shiro:hasPermission> --%>
		   			<shiro:hasPermission name="bus:g_asset:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
