<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>委托交易记录列表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/bus/g_trade_record_coin_usdt/list',
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
				idField : 'id',
				sortName : '',
				sortOrder : '',
				remotesort: true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'id',
					hidden : true
				} ] ],
				columns : [ [ 
					{
						title : '交易类型',
						field : 'trade_type',
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
						title : '交易对编号',
						field : 'pair_id',
						width : 150,
						align : 'center'
					},
					{
						title : '交易对符号',
						field : 'pair_symbol',
						width : 150,
						align : 'center'
					},
					{
						title : '订单编号',
						field : 'order_id',
						width : 150,
						align : 'center'
					},
					{
						title : '原始用户编号',
						field : 'object_uid',
						width : 150,
						align : 'center'
					},
					{
						title : '交易日期',
						field : 'trade_time',
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
						title : '交易价格',
						field : 'trade_price',
						width : 150,
						align : 'center'
					},
					{
						title : '订单数量',
						field : 'order_number',
						width : 150,
						align : 'center'
					},
					{
						title : '金额',
						field : 'amount',
						width : 150,
						align : 'center'
					},
					{
						title : '交易状态',
						field : 'trade_status',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 1) {
								return "<font>交易中</font>";
							}
							if (value == 2) {
								return "<font>已付款</font>";
							}
							if (value == 3) {
								return "<font>交易成功</font>";
							}
							if (value == 4) {
								return "<font>交易失败</font>";
							}
							if (value == 5) {
								return "<font>系统取消</font>";
							}
							if (value == 6) {
								return "<font>系统放行</font>";
							}
							return value;
						}
					},
					{
						title : '交易用户编号',
						field : 'uid',
						width : 150,
						align : 'center'
					},
					{
						title : '手续费',
						field : 'service_charge',
						width : 150,
						align : 'center'
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
						<shiro:hasPermission name="bus:g_trade_record_coin_usdt:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/bus/g_trade_record_coin_usdt/info?id='+row.id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_trade_record_coin_usdt:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/bus/g_trade_record_coin_usdt/toUpdate?id='+row.id+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_trade_record_coin_usdt:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.id+')"><i class="fa fa-trash-o"></i>删除</a></li>';
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
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/bus/g_trade_record_coin_usdt/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/bus/g_trade_record_coin_usdt/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/bus/g_trade_record_coin_usdt/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>委托交易记录列表</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<shiro:hasPermission name="bus:g_trade_record_coin_usdt:view">
		   			<span>订单编号:</span><input name = "g_trade_record_coin_usdt_vo.order_id" />
		   			<span>交易用户编号:</span><input name = "g_trade_record_coin_usdt_vo.uid"/>
		   			<span>原始用户编号:</span><input name = "g_trade_record_coin_usdt_vo.object_uid"/>
		   			<span>交易类型:</span>
		   			<select name = "g_trade_record_coin_usdt_vo.trade_type">
						<option value = "">--请选择--</option>
						<option value = "1">买入</option>
						<option value = "2">卖出</option>
		   			</select>
		   			<span>交易状态:</span>
		   			<select name = "g_trade_record_coin_usdt_vo.trade_status">
		   				<option value = "">--请选择</option>
		   				<option value = "1">交易中</option>
		   				<option value = "2">已付款</option>
		   				<option value = "3">交易成功</option>
		   				<option value = "4">交易失败</option>
		   				<option value = "5">系统取消</option>
		   				<option value = "6">系统放行</option>
		   			</select>
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="bus:g_trade_record_coin_usdt:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
