<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种资料修改</title>
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
	          editor = KindEditor.create('textarea[name="currencyData.dataBrief"]',{resizeType : 1,width:"115%",height:"200px",afterChange:function(){  
	               this.sync();
	           },afterBlur:function(){  
	               this.sync();  
	           }});  
	          editor.html(document.getElementById("currencyDescBak").value);
	    });  
	</script>  
  </head>
  <body>
  	<form id="formobj" action="${ctx}/biz/currencyData/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">币种简介<font color='red'>*</font>：</label>
	        <div class="controls">
	        	 <input name="currencyDescBak" id="currencyDescBak" disabled="disabled" value="${item.dataBrief}" class="inputxt" type="hidden">
	        	 <textarea rows="3" style="width:700px;" id="currencyData.dataBrief" name="currencyData.dataBrief"></textarea>  
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyData.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="currencyData.dataId" value="${item.dataId}"/>
	</form>
  </body>
</html>
