<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>委托单历史订单列表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/bus/g_entrust_order_record_usdt/list',
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
				idField : 'entrust_order_id',
				sortName : '',
				sortOrder : '',
				remotesort: true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'entrust_order_id',
					hidden : true
				} ] ],
				columns : [ [ 
					{
						title : '订单号',
						field : 'order_id',
						width : 150,
						align : 'center'
					},
					{
						title : '下单用户编号',
						field : 'uid',
						width : 150,
						align : 'center'
					},
					{
						title : '币种交易对编号',
						field : 'pair_id',
						width : 150,
						align : 'center'
					},
					{
						title : '交易类型',
						field : 'entrust_type',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 1) {
								return "<font>买入</font>";
							}
							if (value == 2) {
								return "<font>卖出</font>";
							}
							return value;
						}
					},
					{
						title : '委托下单日期',
						field : 'order_time',
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
						title : '价格(USDT)',
						field : 'entrust_price',
						width : 150,
						align : 'center'
					},
					{
						title : '交易币种的挂单量',
						field : 'entrust_amount',
						width : 150,
						align : 'center'
					},
					{
						title : '已成交数量',
						field : 'finished_amount',
						width : 150,
						align : 'center'
					},
					{
						title : '未成交数量',
						field : 'unfinished_amount',
						width : 150,
						align : 'center'
					},
					{
						title : '交易状态',
						field : 'deal_status',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 1) {
								return "<font>完全成交</font>";
							}
							if (value == 2) {
								return "<font>部分成交</font>";
							}
							return value;
						}
					},
					{
						title : '订单状态',
						field : 'order_status',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 1) {
								return "<font>委托中</font>";
							}
							if (value == 2) {
								return "<font>全部成交</font>";
							}
							if (value == 3) {
								return "<font>部分成交</font>";
							}
							if (value == 4) {
								return "<font>撤销</font>";
							}
							return value;
						}
					},
					{
						title : '订单完成时间',
						field : 'order_finished_time',
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
						<shiro:hasPermission name="bus:g_entrust_order_record_usdt:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/bus/g_entrust_order_record_usdt/info?id='+row.entrust_order_id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_entrust_order_record_usdt:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/bus/g_entrust_order_record_usdt/toUpdate?id='+row.entrust_order_id+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_entrust_order_record_usdt:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.entrust_order_id+')"><i class="fa fa-trash-o"></i>删除</a></li>';
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
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/bus/g_entrust_order_record_usdt/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/bus/g_entrust_order_record_usdt/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/bus/g_entrust_order_record_usdt/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>委托单历史订单列表</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
					<span>委托单号:</span><input name = "g_entrust_order_usdt_vo.order_id"/>
		   			<span>用户编号:</span><input name = "g_entrust_order_usdt_vo.uid"/>
		   			<span>交易类型:</span>
		   			<select name = "g_entrust_order_usdt_vo.entrust_type">
		   				<option value="">--请选择--</option>
		   				<option value="1">买入</option>
		   				<option value="2">卖出</option>
		   			</select>
		   			<span>订单状态:</span>
		   			<select name = "g_entrust_order_usdt_vo.order_status">
		   				<option value="">--请选择--</option>
		   				<option value="1">委托中</option>
		   				<option value="2">全部成交</option>
		   				<option value="3">部分成交</option>
		   				<option value="4">撤销</option>
		   			</select>
		   			<span>交易状态:</span>
		   			<select name = "g_entrust_order_usdt_vo.deal_status">
		   				<option value="">--请选择--</option>
		   				<option value="1">完全成交</option>
		   				<option value="2">部分成交</option>
		   			</select>
		   			<shiro:hasPermission name="bus:g_entrust_order_record_usdt:view">
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="bus:g_entrust_order_record_usdt:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
