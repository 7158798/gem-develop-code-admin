<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>通知公告详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
    
     <script type="text/javascript">  
    	var editor;  
	    $(function() {  
	          editor = KindEditor.create('textarea[name="txtIdCN"]',{resizeType : 1,width:"117%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("txtIdCNBak").value);
	    });  
	</script> 
	
	<script type="text/javascript">  
    	var editor;  
	    $(function() {  
	          editor = KindEditor.create('textarea[name="txtIdEN"]',{resizeType : 1,width:"117%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("txtIdENBak").value);
	    });  
	</script> 
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">类型：</label>
	        <div class="controls">
	        	<c:if test="${item.type == 1}">
		        	<input disabled="disabled" value="官方公告" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.type == 2}">
		        	<input disabled="disabled" value="行业资讯" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">标题：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.titleCN}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">标题(英文)：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.titleEN}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">内容：</label>
	        <div class="controls">
	        	<input name="txtIdCNBak" id="txtIdCNBak" disabled="disabled" value="${item.txtIdCN}" class="inputxt" type="hidden">
	        	<textarea rows="3" style="width:700px;" id="txtIdCN" name="txtIdCN"></textarea>  
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">内容(英文)：</label>
	        <div class="controls">
	       		<input name="txtIdENBak" id="txtIdENBak" disabled="disabled" value="${item.txtIdEN}" class="inputxt" type="hidden">
	        	<textarea rows="3" style="width:700px;" id="txtIdEN" name="txtIdEN"></textarea>  
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">来源：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.source}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">操作人编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.sysUid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">操作人名称：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.sysName}" class="inputxt" type="text">
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
