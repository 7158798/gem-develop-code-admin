<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户信息修改</title>
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
  </head>
  <body>
  	<form id="formobj" action="${ctx}/bus/g_user/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">国家<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="g_user.country_code">
		        	<c:if test="${item.country_code == 86}">
	        			<option value="86" selected="selected">中国</option>
	        			<option value="999">其他</option>
		        	</c:if>
		        	<c:if test="${item.country_code != 86}">
	        			<option value="86">中国</option>
	        			<option value="999" selected="selected">其他</option>
		        	</c:if>
	        	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">用户手机<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_user.phone_code" value="${item.phone_code}" class="inputxt"  datatype="m"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">用户邮箱<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_user.mail" value="${item.mail}" class="inputxt"  datatype="e"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否是商户<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="g_user.is_supplier">
		        	<c:if test="${item.is_supplier == 0}">
	   					<option value="0" selected= "selected">不是</option>
	   					<option value="1">是</option>
	   				</c:if>
	   				<c:if test="${item.is_supplier == 1}">
	   					<option value="0">不是</option>	
	   					<option value="1" selected= "selected">是</option>
	   				</c:if>
			   	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">用户状态<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="g_user.status">
		        	<c:if test="${item.status == 1}">
	   					<option value="1" selected= "selected">正常</option>
	   					<option value="2">冻结</option>
	   				</c:if>
	   				<c:if test="${item.status == 2}">
	   					<option value="1">正常</option>	
	   					<option value="2" selected= "selected">冻结</option>
	   				</c:if>
			   	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_user.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="g_user.uid" value="${item.uid}"/>
	</form>
  </body>
</html>
