<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>短信邮件发送状态列表</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/bus/g_message_state/list',
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
						title : '业务类型',
						field : 'type',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == 1) {
								return "<font>短信验证码</font>";
							}
							if (value == 2) {
								return "<font>邮箱验证码</font>";
							}
							if (value == 3) {
								return "<font>邮箱激活码</font>";
							}
							return value;
						}
					},
					{
						title : '国家代码',
						field : 'country_code',
						width : 150,
						align : 'center',
						formatter :function (value,row,index){
							if (value == "86") {
								return "<font>中国</font>";
							}
							if (value == "60") {
								return "<font>马来西亚</font>";
							}
							if (value == "1") {
								return "<font>美国</font>";
							}
							return value;
						}
					},
					{
						title : '接收账号',
						field : 'receiver',
						width : 150,
						align : 'center'
					},
					{
						title : '发送状态',
						field : 'status',
						width : 150,
						align : 'center'
					},
					{
						title : '业务编号',
						field : 'biz_id',
						width : 150,
						align : 'center'
					},
					{
						title : '用户编号',
						field : 'uid',
						width : 150,
						align : 'center'
					},
					{
						title : 'IP',
						field : 'client_ip',
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
						<shiro:hasPermission name="bus:g_message_state:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/bus/g_message_state/info?id='+row.id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_message_state:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/bus/g_message_state/toUpdate?id='+row.id+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:g_message_state:delete">
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
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/bus/g_message_state/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/bus/g_message_state/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/bus/g_message_state/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>短信邮件发送状态列表</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<shiro:hasPermission name="bus:g_message_state:view">
		   			<span>业务编号:</span><input name = "g_message_state_vo.biz_id"/>
		   			<span>用户编号:</span><input name = "g_message_state_vo.uid"/>
		   			<span>业务类型:</span>
		   			<select name = "g_message_state_vo.type">
		   				<option value="">--请选择--</option>
		   				<option value="1">短信验证码</option>
		   				<option value="2">邮箱验证码</option>
		   				<option value="3">邮箱激活码</option>
		   			</select>
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="bus:g_message_state:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
