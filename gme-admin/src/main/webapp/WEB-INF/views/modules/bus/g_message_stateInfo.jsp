<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>短信邮件发送状态详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
    
    <script type="text/javascript">  
    	var editor;  
	    $(function() {  
	          editor = KindEditor.create('textarea[name="biz_content"]',{resizeType : 1,width:"115%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("biz_content_bak").value);
	    });  
	</script>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">业务类型：</label>
	        <div class="controls">
	        	<c:if test="${item.type == 1}">
		        	<input disabled="disabled" value="短信验证码" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.type == 2}">
		        	<input disabled="disabled" value="邮箱验证码" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.type == 3}">
		        	<input disabled="disabled" value="邮箱激活码" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">国家代码：</label>
	        <div class="controls">
	        	<c:if test="${item.country_code == '86'}">
		        	<input disabled="disabled" value="中国" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.country_code == '60'}">
		        	<input disabled="disabled" value="马来西亚" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.country_code == '1'}">
		        	<input disabled="disabled" value="美国" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">接收账号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.receiver}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">发送状态：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.status}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">异常描述：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.error_reason}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">业务编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.biz_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">业务概述：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.biz_desc}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">业务内容：</label>
	        <div class="controls">
	        	<input name="biz_content_bak" id="biz_content_bak" disabled="disabled" value="${item.biz_content}" class="inputxt" type="hidden">
	        	<textarea rows="3" style="width:700px;" id="biz_content" name="biz_content"></textarea>  
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">IP：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.client_ip}" class="inputxt" type="text">
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
