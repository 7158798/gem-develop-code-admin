<%@ page language="java" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>修改我的信息</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  $(function(){ 
				  $("#formobj").Validform({ 
					  tiptype:4,
					  btnSubmit:"#btn_sub",
					  btnReset:"#btn_reset",
					  ajaxPost:true,
					  callback:function(data){   
					   if(data.success==true){ 
						  tip(data.msg);
					   }else{
					   	 tip(data.msg); 
						 return false;
					   } 
					}
				});
	  });
	</script>
	<script type="text/javascript">
		function checkPasswork(){
			var userpwd = $("#sys_user.userpwd").val();
			var reUserpwd = $("#reUserpwd").val();
			if (userpwd == reUserpwd) {
				alert("正确");
				document.form[0].submit;
			}
		}
	</script>
  </head>
  <body style="overflow:hidden;">
  	<div class="easyui-panel" data-options="fit:true">
	    <div class="psflow-panpel-maintitle" style="border:1px solid #dcdcdc">
			<h2 class="psflow-panpel-title"><span>修改个人信息</span></h2>
		</div>
		<form id="formobj" action="${ctx}/sys/sys_user/curUpdate" name="formobj" method="post" class="form-horizontal">
			<div class="control-group">
	        	<label class="control-label Validform_label">登录名<font color="red">*</font>：</label>
		        <div class="controls">
		        	<input name="sys_user.username" value="${item.username}" datatype="*1-100" class="inputxt" type="text">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">真实姓名<font color="red">*</font>：</label>
		        <div class="controls">
		        	<input name="sys_user.truename" value="${item.truename}" datatype="*0-100" class="inputxt" type="text">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">密码<font color="red">*</font>：</label>
		        <div class="controls">
		        	<input id="sys_user.userpwd" name="sys_user.userpwd"  datatype="n1-200" class="inputxt" type="password">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">确认密码<font color="red">*</font>：</label>
		        <div class="controls">
		        	<input id="reUserpwd" name="reUserpwd"  datatype="n1-200" class="inputxt" type="password">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">手机号码：</label>
		        <div class="controls">
		        	<input name="sys_user.phone" value="${item.phone}" ignore="ignore" errormsg="手机号码无效" datatype="m" class="inputxt" type="text">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">qq：</label>
		        <div class="controls">
		        	<input name="sys_user.qq" value="${item.qq}" datatype="n" ignore="ignore" errormsg="只能是数字" class="inputxt" type="text">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">邮箱：</label>
		        <div class="controls">
		        	<input name="sys_user.email" value="${item.email}" datatype="e" ignore="ignore" errormsg="邮箱无效" class="inputxt" type="text">
		        </div>
	      	</div>
	      	<div class="control-group">
	        	<label class="control-label Validform_label">&nbsp;</label>
		        <div class="controls">
		        	<input type="button" onclick="javascript:checkPasswork();" value="确定" id="btn_sub" class="btn_sub u-btn u-btn-cg" style="width:85px; margin-right:12px; color:#fff;">
					<input type="reset" value="重置" id="btn_reset" class="btn_sub u-btn u-btn-cgray" style="width:85px;">
		        </div>
	      	</div>
	      	<input name="sys_user.id" value="${item.id}" style="display: none;"/>
		</form>
	</div>
  </body>
</html>
