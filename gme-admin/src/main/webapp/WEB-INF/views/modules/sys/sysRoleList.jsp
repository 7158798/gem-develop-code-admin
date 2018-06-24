<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.manage.base.util.UserUtil"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>角色列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/sys/sysRole/list',
				method: 'POST',
				iconCls : '',
				fit : true,
				fitColumns:true,
				nowarp : false,
				border : true,
				idField : 'id',
				remotesort: true,
				rownumbers:true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'id',
					hidden : true
				} ] ],
				columns : [ [ 
				{
					title : '角色名称',
					field : 'rolename',
					align : 'left',
					width : 250
				},	
				{
					title : '说明',
					field : 'remark',
					align : 'left',
					width : 350
				},	
				{
					title : '操作',
					field : '_opt',
					align : 'center',
					width : 100,
					formatter:function (value, row, index){
						var a = '';var b = '';var c = '';var d = '';
						var div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a>';
						<shiro:hasPermission name="sys:sysRole:view">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/sys/sysRole/info?id='+row.id+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="sys:sysRole:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/sys/sysRole/toUpdate?id='+row.id+'\',\'dataGrid\',null,null)"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="sys:sysRole:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.id+')"><i class="fa fa-trash-o"></i>删除</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="sys:sysRole:update">
							d = "<li><a href='javaScript:void(0);' onclick='setRoleMenu(\""+row.id+"\",\""+row.rolename+"\");'><i class='fa fa-gear'></i>设置权限</a></li>";
						</shiro:hasPermission>
                        if(row.id!=1 || (row.id==1 && '<%=UserUtil.getCurUser().getId().toString()%>'=='1')){ 
                        	//return a+b+c+d;
                        	div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a><ul class="u-menu">'+ a + b + c + d +'</ul></div>';
                        	return div;
                        }
					}
				}
				] ]
			});
	  	});
        function deleterow(id){
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/sys/sysRole/delete?id='+id,'dataGrid');
        }
	  	function reloadTable(){
	  		try{	
				$('#dataGrid').datagrid('reload');	
			}catch(ex){
			}
	  	}
		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/sys/sysRole/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function setRoleMenu(id,roleName){
	        $.dialog({
				content: 'url:${ctx}/sys/sysRole/listRoleMenu?sysRoleVO.id='+id,
				lock : true,
				width:600,
				height:500,
				title:'设置权限',
				opacity : 0.3,
				cache:false,
			    ok: function(){
			    	iframe = this.iframe.contentWindow;
					saveObj();
					return false;
			    },
			    cancelVal: '关闭',
			    cancel: true /*为true等价于function(){}*/
			}).zindex();
		}
	</script>
  </head>
  <body class="psflow-panpel-body">
  	<table id="dataGrid"></table>
	<div id="toolDiv" style="padding:2px 5px;">
		<div class="psflow-panpel-maintitle">
			<h2 class="psflow-panpel-title"><span>角色列表</span></h2>
		</div>
		<div class="psflow-panpel-tooldiv">
			<div class="tooldiv" id="toolDivNew">
				<span>角色名称:</span><input type="text" name="sysRoleVO.roleName"/>
				<shiro:hasPermission name="sys:sysRole:view">
					<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	    			<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
				</shiro:hasPermission>
				<shiro:hasPermission name="sys:sysRole:add">
	      			<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="add('新增','${ctx}/sys/sysRole/toAdd','dataGrid',null,null);"><i class="fa fa-fw fa-plus"></i>添加</a>
	   			</shiro:hasPermission>
			</div>
		</div>
	</div>
  </body>
</html>
