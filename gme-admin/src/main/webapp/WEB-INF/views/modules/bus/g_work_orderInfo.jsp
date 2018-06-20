<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>工单详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
    
    <script type="text/javascript">  
    	var editor;  
	    $(function() {  
	          editor = KindEditor.create('textarea[name="work_content"]',{resizeType : 1,width:"117%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("work_content_bak").value);
	    });  
	</script> 
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">工单ID：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.work_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">工单主题：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.subject}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">工单类型：</label>
	        <div class="controls">
	        	<c:if test="${item.work_type == 1}">
		        	<input disabled="disabled" value="充值" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.work_type == 2}">
		        	<input disabled="disabled" value="提现" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.work_type == 3}">
		        	<input disabled="disabled" value="申诉" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.work_type == 4}">
		        	<input disabled="disabled" value="仲裁" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.work_type == 5}">
		        	<input disabled="disabled" value="其他" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种类型：</label>
	        <div class="controls">
	        	<c:if test="${item.currency_id == 1}">
		        	<input disabled="disabled" value="usdt" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.work_type == 2}">
		        	<input disabled="disabled" value="eos" class="inputxt" type="text">
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
        	<label class="control-label Validform_label">内容：</label>
	        <div class="controls">
	       		<input name="work_content_bak" id="work_content_bak" disabled="disabled" value="${item.work_content}" class="inputxt" type="hidden">
	        	<textarea rows="3" style="width:700px;" id="work_content" name="work_content"></textarea>  
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">图片编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.work_img_id}" class="inputxt" type="text">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">图片：</label>
	        <div class="controls">
	        	<c:forEach items="${item.images}" var="image">
	        		<img src="${image}"  width="100px" height="100px">
	        	</c:forEach>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">提交用户：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">账户ID：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.account_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">手机号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.phone_code}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">用户名称：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.name}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">提交时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.submit_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">处理客服：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.sys_uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">客服名称：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.sys_name}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">处理时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.finished_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">工单状态：</label>
	        <div class="controls">
	        	<c:if test="${item.work_status == 1}">
		        	<input disabled="disabled" value="未处理" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.work_status == 2}">
		        	<input disabled="disabled" value="处理中" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.work_status == 3}">
		        	<input disabled="disabled" value="已处理" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">答复限制往来次数限制：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.reply_limit}" class="inputxt" type="text">
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
