<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>身份认证新增</title>
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
  	<form id="formobj" action="${ctx}/bus/g_identity_auth/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">用户编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.uid" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">真实姓名<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.real_name" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">证件类型:1-身份证;2-护照;3-军官证;4-台湾居民通行证;5-港澳居民通行证;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.certificate_type " value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">证件号码<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.certificate_number" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否是认证商家true/false<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.is_auth_supplier" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">证件背面图片编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.reverse_img_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">证件证面图片编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.front_img_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">手持证件图片编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.in_hand_img_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">认证状态:1-未认证;2-认证中;3-已通过认证;4-未通过认证;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.auth_status" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">反馈<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.feedback" value="" class="inputxt" datatype="*1-200"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">记录状态0-正常;1-异常;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.status" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.version" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.create_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_identity_auth.updated_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
