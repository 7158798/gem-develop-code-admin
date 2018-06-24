<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>工单答复详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
    
    <script type="text/javascript">  
    	var editor;  
	    $(function() {  
	          editor = KindEditor.create('textarea[name="content"]',{resizeType : 1,width:"117%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("contentBak").value);
	    });  
	</script> 
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">主题编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.subjectId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">答复内容：</label>
	        <div class="controls">
	       		<input name="contentBak" id="contentBak" disabled="disabled" value="${item.content}" class="inputxt" type="hidden">
	        	<textarea rows="3" style="width:700px;" id="content" name="content"></textarea>  
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">图片编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.replyImgId}" class="inputxt" type="text">
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
        	<label class="control-label Validform_label">答复角色：</label>
	        <div class="controls">
	        	<c:if test="${item.type == 0}">
		        	<input disabled="disabled" value="客服" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.type == 1}">
		        	<input disabled="disabled" value="用户" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">答复者UID：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">答复者：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.name}" class="inputxt" type="text">
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
