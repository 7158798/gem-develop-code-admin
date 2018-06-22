<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>商家信息列表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/bus/g_supplier_info/list',
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
				idField : 'uid',
				sortName : '',
				sortOrder : '',
				remotesort: true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'uid',
					hidden : true
				} ] ],
				columns : [ [ 
					{
						title : '商家名称',
						field : 'supplier_name',
						width : 150,
						align : 'center'
					},
					{
						title : '是否认证',
						field : 'is_auth',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 1) {
								return "<font>是</font>";
							}
							if (value == 2) {
								return "<font>否</font>";
							}
							return value;
						}
					},
					{
						title : '是否是媒介币',
						field : 'is_token',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 0) {
								return "<font>不是</font>";
							}
							if (value == 1) {
								return "<font>是</font>";
							}
							return value;
						}
					},
					{
						title : '币种符号',
						field : 'currency_symbol',
						width : 150,
						align : 'center'
					},
					{
						title : '订单总数',
						field : 'total_number',
						width : 150,
						align : 'center'
					},
					{
						title : '总成交数',
						field : 'total_deal_number',
						width : 150,
						align : 'center'
					},
					{
						title : '取消次数',
						field : 'cancel_time',
						width : 150,
						align : 'center'
					},
					{
						title : '被投诉次数',
						field : 'complained_number',
						width : 150,
						align : 'center'
					},
					{
						title : '保证金',
						field : 'deposit',
						width : 150,
						align : 'center'
					},
					{
						title : '被冻结的保证金',
						field : 'frozen_deposit',
						width : 150,
						align : 'center'
					},
					{
						title : '商家状态',
						field : 'supplier_status',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 1) {
								return "<font>正常</font>";
							}
							if (value == 2) {
								return "<font>冻结</font>";
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
						<shiro:hasPermission name="bus:g_supplier_info:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/bus/g_supplier_info/info?id='+row.uid+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_supplier_info:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/bus/g_supplier_info/toUpdate?id='+row.uid+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_supplier_info:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.uid+')"><i class="fa fa-trash-o"></i>删除</a></li>';
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
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/bus/g_supplier_info/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/bus/g_supplier_info/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/bus/g_supplier_info/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>商家信息管理</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<shiro:hasPermission name="bus:g_supplier_info:view">
		   			<span>商家名称:</span><input name="g_supplier_info_vo.supplier_name"/>
		   			<span>是否认证:</span>
		   			<select name="g_supplier_info_vo.is_auth">
		   				<option value="">--请选择--</option>
		   				<option value="1">是</option>
		   				<option value="2">否</option>
		   			</select>
		   			<span>是否是媒介币:</span>
		   			<select name="g_supplier_info_vo.is_token">
		   				<option value="">--请选择--</option>
		   				<option value="0">不是</option>
		   				<option value="1">是</option>
		   			</select>
		   			<span>商家状态:</span>
		   			<select name="g_supplier_info_vo.supplier_status">
		   				<option value="">--请选择--</option>
		   				<option value="1">正常</option>
		   				<option value="2">冻结</option>
		   			</select>
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="bus:g_supplier_info:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
