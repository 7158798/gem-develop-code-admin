<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>操作日志详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
    
    <script type="text/javascript">  
    	var editor;  
	    $(function() {  
	          editor = KindEditor.create('textarea[name="error_reason"]',{resizeType : 1,width:"115%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("error_reason_bak").value);
	    });  
	</script>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">业务类型：</label>
	        <div class="controls">
	        	<c:if test="${item.biz_type == 1}">
		        	<input disabled="disabled" value="提现" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.biz_type == 2}">
		        	<input disabled="disabled" value="充值" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.biz_type == 3}">
		        	<input disabled="disabled" value="交易" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">业务编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.biz_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">业务描述：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.biz_desc}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">客户端IP：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.client_ip}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">客户端类型：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.client_type}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">HTTP信息：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.http_user_agent}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">状态：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.status}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">异常信息：</label>
	        <div class="controls">
	        	<input name="error_reason_bak" id="error_reason_bak" disabled="disabled" value="${item.error_reason}" class="inputxt" type="hidden">
	        	<textarea rows="3" style="width:700px;" id="error_reason" name="error_reason"></textarea> 
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">备注：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.remark}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">创建时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.create_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">更新时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.updated_time}" class="inputxt" type="text">
	        </div>
      	</div>
  	</div>
  </body>
</html>
