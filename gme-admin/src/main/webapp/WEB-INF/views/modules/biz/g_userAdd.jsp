<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户信息新增</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%> 
	<script type="text/javascript">
	  $(function(){$("#formobj").Validform({
		  tiptype:4,
		  btnSubmit:"#btn_sub",
		  btnReset:"#btn_reset",
		  ajaxPost:true,
		  callback:function(data){
		   var win = frameElement.api.opener;
		   if(data.success==true){
			  frameElement.api.close();win.tip(data.msg);
		   }else{
		   	 tip(data.msg);
			 return false;
		   }
		   win.reloadTable();
		 }
		});});
	</script>
  </head>
  <body>
  	<form id="formobj" action="${ctx}/bus/g_user/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">用户名称<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_user.name" value="" class="inputxt" datatype="*1-30"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">登录密码<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_user.password" value="" class="inputxt" datatype="*1-32"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">国家号码<font color='red'>*</font>：</label>
	        <div class="controls">
        		<select name="g_user.country_code">
	        		<option value="86">中国</option>
	        		<option value="999">其他</option>
        		</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">用户手机<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_user.phone_code" value="" class="inputxt" datatype="m"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">用户邮箱<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_user.mail" value="" class="inputxt" datatype="e"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否是商户<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="g_user.is_supplier">
	        		<option value="0">不是</option>
	        		<option value="1">是</option>
	        	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">资金密码<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_user.trade_auth" value="" class="inputxt" datatype="*1-32"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_user.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
