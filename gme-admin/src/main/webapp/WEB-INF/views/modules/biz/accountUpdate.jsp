<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户账户信息修改</title>
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
  	<form id="formobj" action="${ctx}/biz/account/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">转账账号<font color='red'>*</font>：</label>
	        <div class="controls">
		        <select name="account.auditStatus">
		        	<c:if test="${item.auditStatus == 1}">
	        			<option value="1" selected="selected">未审核</option>
	        			<option value="2">通过审核</option>
		        	</c:if>
		        	<c:if test="${item.auditStatus == 2}">
	        			<option value="1">未审核</option>
	        			<option value="2" selected="selected">通过审核</option>
		        	</c:if>
		        </select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">账户状态<font color='red'>*</font>：</label>
	        <div class="controls">
	         	<select name="account.accountStatus">
		        	<c:if test="${item.accountStatus == 1}">
	        			<option value="1" selected="selected">正常</option>
	        			<option value="2">冻结</option>
		        	</c:if>
		        	<c:if test="${item.accountStatus == 2}">
	        			<option value="1">正常</option>
	        			<option value="2" selected="selected">冻结</option>
		        	</c:if>
		        </select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="account.uid" value="${item.uid}"/>
	</form>
  </body>
</html>
