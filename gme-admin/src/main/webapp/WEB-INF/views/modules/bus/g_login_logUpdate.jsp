<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>登录日志表（g_login_log）
功能描述：存储用户登录日志信息。
修改</title>
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
  	<form id="formobj" action="${ctx}/bus/g_login_log/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">用户编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.uid" value="${item.uid}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">登录账号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.account" value="${item.account}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">IP<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.login_ip" value="${item.login_ip}" class="inputxt"  datatype="*1-20"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">IP归属地址<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.home_address" value="${item.home_address}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">登录客户端pc / ios / ard<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.client_type" value="${item.client_type}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">HTTP信息	<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.http_user_agent" value="${item.http_user_agent}" class="inputxt"  datatype="*1-100"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">状态success  / failed.<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.status" value="${item.status}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">异常信息<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.error_reason" value="${item.error_reason}" class="inputxt"  datatype="*1-3000"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.version" value="${item.version}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.create_time" value="${item.create_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.updated_time" value="${item.updated_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="g_login_log.log_id" value="${item.log_id}"/>
	</form>
  </body>
</html>
