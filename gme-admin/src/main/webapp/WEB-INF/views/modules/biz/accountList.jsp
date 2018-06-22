<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>用户账户支付信息列表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/biz/account/list',
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
						title : '账号ID',
						field : 'accountId',
						width : 150,
						align : 'center'
					},
					{
						title : '真实姓名',
						field : 'realName',
						width : 150,
						align : 'center'
					},
					{
						title : '银行卡类型',
						field : 'cardType',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value==1) {
								return "<font>借记卡</font>";
							}if (value==2) {
								return "<font>信用卡</font>";
							}
							return value;
						}
					},
					{
						title : '银行卡号',
						field : 'cardNumber',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value==null) {
								return "<font>暂无绑定</font>";
							}
							return value;
						}
					},
					{
						title : '开户银行',
						field : 'bankName',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value==null) {
								return "<font>暂无</font>";
							}
							return value;
						}
					},
					{
						title : '开户支行',
						field : 'bankBranchName',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value==null) {
								return "<font>暂无</font>";
							}
							return value;
						}
					},
					{
						title : '支付宝账号',
						field : 'alipayAccount',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value==null) {
								return "<font>暂无绑定</font>";
							}
							return value;
						}
					},
					{
						title : '微信账号',
						field : 'wxAccount',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value==null) {
								return "<font>暂无绑定</font>";
							}
							return value;
						}
					},
					{
						title : '转账状态',
						field : 'auditStatus',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value==1) {
								return "<font>未审核</font>";
							}
							if (value==2) {
								return "<font>通过审核</font>";
							}
							return value;
						}
					},
					{
						title : '账户状态',
						field : 'accountStatus',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value==1) {
								return "<font>正常</font>";
							}
							if (value==2) {
								return "<font>冻结</font>";
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
						<shiro:hasPermission name="biz:account:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/biz/account/info?id='+row.uid+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="biz:account:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/biz/account/toUpdate?id='+row.uid+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="biz:account:delete">
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
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/biz/account/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/biz/account/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/biz/account/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>用户账户支付信息列表</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<shiro:hasPermission name="biz:account:view">
		   			<span>用户姓名:</span><input type="text" name="accountVO.realName" />
		   			<span>银行卡类型:</span>
		   			<select name="accountVO.cardType">
		   				<option value="">--请选择--</option>
		   				<option value="1">借记卡</option>
		   				<option value="2">信用卡</option>
		   			</select>
		   			<span>转账状态:</span>
		   			<select name="accountVO.auditStatus">
		   				<option value="">--请选择--</option>
		   				<option value="1">未审核</option>
		   				<option value="2">通过审核</option>
		   			</select>
		   			<span>账户状态:</span>
		   			<select name="accountVO.accountStatus">
		   				<option value="">--请选择--</option>
		   				<option value="1">正常</option>
		   				<option value="2">冻结</option>
		   			</select>
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="biz:account:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
