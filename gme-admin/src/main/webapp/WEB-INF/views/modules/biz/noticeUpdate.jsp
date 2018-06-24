<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>通知公告修改</title>
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
	<script type="text/javascript">  
    	var editor;  
	    $(function() {  
	          editor = KindEditor.create('textarea[name="notice.txtIdCN"]',{resizeType : 1,width:"117%",height:"200px",afterChange:function(){  
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
	          editor = KindEditor.create('textarea[name="notice.txtIdEN"]',{resizeType : 1,width:"117%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("txtIdENBak").value);
	    });  
	</script> 
  </head>
  <body>
  	<form id="formobj" action="${ctx}/biz/notice/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">类型<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name = "notice.type">
		        	<c:if test="${item.type == 1}">
		        		<option value = "1" selected="selected">官方公告</option>
		        		<option value = "2">行业资讯</option>
		        	</c:if>
		        	<c:if test="${item.type == 2}">
		        		<option value = "1">官方公告</option>
		        		<option value = "2" selected="selected">行业资讯</option>
		        	</c:if>
	        	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">标题<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="notice.titleCN" value="${item.titleCN}" class="inputxt"  datatype="*1-300"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">标题(英文)<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="notice.titleEN" value="${item.titleEN}" class="inputxt"  datatype="*1-300"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">内容<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="txtIdCNBak" id="txtIdCNBak" disabled="disabled" value="${item.txtIdCN}" class="inputxt" type="hidden">
	        	<textarea  rows="3" style="width:500px;" id="txtIdCN" name="notice.txtIdCN"></textarea>  
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">内容(英文)<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="txtIdENBak" id="txtIdENBak" disabled="disabled" value="${item.txtIdEN}" class="inputxt" type="hidden">
	        	<textarea rows="3" style="width:500px;" id="txtIdEN" name="notice.txtIdEN"></textarea>  
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">来源<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="notice.source" value="${item.source}" class="inputxt"  datatype="*1-200"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">操作人编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="notice.sysUid" value="${item.sysUid}" class="inputxt"  datatype="n1-36"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">操作人名称<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="notice.sysName" value="${item.sysName}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="notice.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="notice.noticeId" value="${item.noticeId}"/>
	</form>
  </body>
</html>
