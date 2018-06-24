<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<%@ include file="/WEB-INF/views/include/head.jsp"%> 
	<script type="text/javascript">
	  $(function(){
		  var ro=$("#formobj").Validform({
		  	  datatype: {"empty":/^\s*$/},
			  tiptype:4,
			  btnSubmit:"#btn_sub",
			  btnReset:"#btn_reset",
			  ajaxPost:true,
			  callback:function(data){
			   var win = frameElement.api.opener;
			   if(data.success==true){
				  frameElement.api.close();win.tip(data.msg);
			   }else{
			   		win.tip(data.msg);
				 	return false;
			   }
			   win.reloadTable();
			 }
			});
			
			ro.addRule([
			{
	            ele: "#userName",
	            datatype: "/^[a-zA-Z0-9]{1,18}$/",
	            nullmsg: "请输入登录名！",
	            ajaxurl: "${ctx}/sys/sysUser/checkUser?sysUserVO.checkType=1",
	            errormsg: "登录名至少1个字符,最多18个字符！"
	        }
	        ]);
		});
	</script>
  </head>
  <body>
  	<form id="formobj" action="${ctx}/sys/sysUser/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">角色<font color="red">*</font>：</label>
	        <div class="controls">
	          	<select class="select" name="sysUser.roleid" datatype="*1-100">
				  	<c:forEach var="role" items="${roles}">
				  		<c:if test="${role.id ne 1}">
				  		<option value="${role.id }">${role.rolename}</option>
				  		</c:if>
				  	</c:forEach>
				</select> 
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">姓名<font color="red">*</font>：</label>
	        <div class="controls">
	        	<input name="sysUser.truename" value="" class="inputxt" datatype="*1-200" type="text">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">登录名<font color="red">*</font>：</label>
	        <div class="controls">
	        	<input name="sysUser.username" value="" class="inputxt" datatype="*1-100" type="text" id="userName">
	        </div>
      	</div>
      	<div class="control-group">
			<label class="control-label Validform_label">
				登录密码<font color="red">*</font>：
			</label>
			<div class="controls">
				<input name="sysUser.userpwd" value="" datatype="s1-100" class="inputxt" nullmsg="请填写登录密码!" errormsg="登录密码格式不正确!" type="password">
			</div>
		</div>	   
		<div class="control-group"> 
			<label class="control-label Validform_label">
				手机号：
			</label>
			<div class="controls">
				<input name="sysUser.phone" value="" class="inputxt" datatype="empty|m" type="text">
			</div>
		</div>  
		<div class="control-group"> 
			<label class="control-label Validform_label">
				联系QQ：
			</label>
			<div class="controls">
				<input name="sysUser.qq" value="" class="inputxt" datatype="empty|n" type="text">
			</div>
		</div>	
		<div class="control-group"> 
			<label class="control-label Validform_label">
				邮箱：
			</label>
			<div class="controls">
				<input name="sysUser.email" value="" class="inputxt" datatype="empty|e" type="text">
			</div>  
		</div>
	</form>
  </body>
</html>
