<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>操作日志表（g_operation_log）
功能描述：存储用户业务操作日志信息。
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
  	<form id="formobj" action="${ctx}/bus/g_operation_log/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">业务类型<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.biz_type" value="${item.biz_type}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">业务编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.biz_id" value="${item.biz_id}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">业务描述<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.biz_desc" value="${item.biz_desc}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">客户端IP<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.client_ip" value="${item.client_ip}" class="inputxt"  datatype="*1-20"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">用户编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.uid" value="${item.uid}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">客户端类型 pc / ios / ard<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.client_type" value="${item.client_type}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">HTTP信息	<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.http_user_agent" value="${item.http_user_agent}" class="inputxt"  datatype="*1-100"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">状态success  / failed.<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.status" value="${item.status}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">异常信息<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.error_reason" value="${item.error_reason}" class="inputxt"  datatype="*1-3000"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.version" value="${item.version}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.create_time" value="${item.create_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_operation_log.updated_time" value="${item.updated_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="g_operation_log.id" value="${item.id}"/>
	</form>
  </body>
</html>
