<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户登录日志详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
    
     <script type="text/javascript">  
    	var editor;  
	    $(function() {  
	          editor = KindEditor.create('textarea[name="errorReason"]',{resizeType : 1,width:"115%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("errorReasonBak").value);
	    });  
	</script>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">登录账号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.account}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">IP：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.loginIp}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">IP归属地址：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.homeAddress}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">登录客户端：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.clientType}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">HTTP信息：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.httpUserAgent}" class="inputxt" type="text">
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
	        	<input name="errorReasonBak" id="errorReasonBak" disabled="disabled" value="${item.errorReason}" class="inputxt" type="hidden">
	        	<textarea rows="3" style="width:700px;" id="errorReason" name="errorReason"></textarea>  
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
	        	<input disabled="disabled" value="${item.createTime}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">更新时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.updatedTime}" class="inputxt" type="text">
	        </div>
      	</div>
  	</div>
  </body>
</html>
