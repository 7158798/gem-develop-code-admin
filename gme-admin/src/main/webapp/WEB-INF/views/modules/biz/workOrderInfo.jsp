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
	          editor = KindEditor.create('textarea[name="workContent"]',{resizeType : 1,width:"117%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("workContentBak").value);
	    });  
	</script> 
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">工单ID：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.workId}" class="inputxt" type="text">
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
	        	<c:if test="${item.workType == 1}">
		        	<input disabled="disabled" value="充值" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.workType == 2}">
		        	<input disabled="disabled" value="提现" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.workType == 3}">
		        	<input disabled="disabled" value="申诉" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.workType == 4}">
		        	<input disabled="disabled" value="仲裁" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.workType == 5}">
		        	<input disabled="disabled" value="其他" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种类型：</label>
	        <div class="controls">
	        	<c:if test="${item.currencyId == 1}">
		        	<input disabled="disabled" value="usdt" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.currencyId == 2}">
		        	<input disabled="disabled" value="eos" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">业务编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.bizId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">内容：</label>
	        <div class="controls">
	       		<input name="workContentBak" id="workContentBak" disabled="disabled" value="${item.workContent}" class="inputxt" type="hidden">
	        	<textarea rows="3" style="width:700px;" id="workContent" name="workContent"></textarea>  
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">图片编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.workImgId}" class="inputxt" type="text">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">图片：</label>
	        <div class="controls">
	        	<c:forEach items="${item.images}" var="image">
	        		<a href="${image}" target="_blank"><img src="${image}"  width="100px" height="100px"></a>
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
	        	<input disabled="disabled" value="${item.accountId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">手机号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.phoneCode}" class="inputxt" type="text">
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
	        	<input disabled="disabled" value="${item.submitTime}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">处理客服：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.sysUid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">客服名称：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.sysName}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">处理时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.finishedTime}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">工单状态：</label>
	        <div class="controls">
	        	<c:if test="${item.workStatus == 1}">
		        	<input disabled="disabled" value="未处理" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.workStatus == 2}">
		        	<input disabled="disabled" value="处理中" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.workStatus == 3}">
		        	<input disabled="disabled" value="已处理" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">答复限制往来次数限制：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.replyLimit}" class="inputxt" type="text">
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
