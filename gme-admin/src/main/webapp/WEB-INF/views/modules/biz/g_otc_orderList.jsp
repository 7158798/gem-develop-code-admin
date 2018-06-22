﻿<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>OTC订单列表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/bus/g_otc_order/list',
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
				idField : 'entry_order_id',
				sortName : '',
				sortOrder : '',
				remotesort: true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'entry_order_id',
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
						title : '挂单用户编号',
						field : 'uid',
						width : 150,
						align : 'center'
					},
					{
						title : '业务类型',
						field : 'order_type',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 1) {
								return "<font>买家</font>";
							}
							if (value == 2) {
								return "<font>卖家</font>";
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
						title : '人民币价格',
						field : 'order_price',
						width : 150,
						align : 'center'
					},
					{
						title : '数量',
						field : 'order_number',
						width : 150,
						align : 'center'
					},
					{
						title : '总金额',
						field : 'order_amount',
						width : 150,
						align : 'center'
					},
					{
						title : '订单状态',
						field : 'order_status',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 1) {
								return "<font>挂单中</font>";
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
							if (value == 5) {
								return "<font>挂单超时</font>";
							}
							return value;
						}
					},
					{
						title : '订单最小金额',
						field : 'order_min_number',
						width : 150,
						align : 'center'
					},
					{
						title : '支付方式',
						field : 'order_pay_type',
						width : 200,
						align : 'center',
						formatter :function (value,row,index){
							if (value == "010202") {
								return "<font>银行卡</font>";
							}
							if (value == "010102") {
								return "<font>银行卡|支付宝</font>";
							}
							if (value == "010201") {
								return "<font>银行卡|微信</font>";
							}
							if (value == "010101") {
								return "<font>银行卡|支付宝|微信</font>";
							}
							if (value == "020102") {
								return "<font>支付宝</font>";
							}
							if (value == "020101") {
								return "<font>支付宝|微信</font>";
							}
							if (value == "020201") {
								return "<font>微信</font>";
							}
							if (value == "020202") {
								return "<font>暂无</font>";
							}
							return value;
						}
					},
					{
						title : '挂单时长限制',
						field : 'order_duration',
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
						<shiro:hasPermission name="bus:g_otc_order:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/bus/g_otc_order/info?id='+row.entry_order_id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_otc_order:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/bus/g_otc_order/toUpdate?id='+row.entry_order_id+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_otc_order:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.entry_order_id+')"><i class="fa fa-trash-o"></i>删除</a></li>';
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
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/bus/g_otc_order/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/bus/g_otc_order/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/bus/g_otc_order/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>OTC订单列表</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<shiro:hasPermission name="bus:g_otc_order:view">
		   			<span>订单号:</span><input name = "g_otc_order_vo.order_id"/>
		   			<span>挂单用户编号:</span><input name = "g_otc_order_vo.uid">
		   			<span>业务类型:</span>
		   			<select name = "g_otc_order_vo.order_type">
		   				<option value = "">--请选择--</option>
		   				<option value = "1">买家</option>
		   				<option value = "2">卖家</option>
		   			</select>
		   			<span>订单状态:</span>
		   			<select name = "g_otc_order_vo.order_status">
		   				<option value = "">--请选择--</option>
		   				<option value = "1">挂单中</option>
		   				<option value = "2">全部成交</option>
		   				<option value = "3">部分成交</option>
		   				<option value = "4">撤销</option>
		   				<option value = "5">挂单超时</option>
		   			</select>
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="bus:g_otc_order:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>