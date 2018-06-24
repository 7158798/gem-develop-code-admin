<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>工单答复新增</title>
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
	          editor = KindEditor.create('textarea[name="workOrderReply.content"]',{resizeType : 1,width:"117%",height:"200px",afterChange:function(){  
	              this.sync();  
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          /* editor.html(document.getElementById("work_content_bak").value); */
	    });  
	</script> 
  </head>
  <body>
  	<form id="formobj" action="${ctx}/biz/workOrderReply/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">主题编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="workOrderReply.subjectId" value="" class="inputxt" datatype="n1-36"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">答复内容<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<textarea rows="3" style="width:700px;" id="workOrderReply.content" name="workOrderReply.content"></textarea>  
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">答复角色;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name ="workOrderReply.type">
	        		<option value="0">客服</option>
	        	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">答复者UID<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="workOrderReply.uid" value="" class="inputxt" datatype="n1-36"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">答复者<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="workOrderReply.name" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="workOrderReply.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
