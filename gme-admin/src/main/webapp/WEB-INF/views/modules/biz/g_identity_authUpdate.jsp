<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>身份认证修改</title>
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
  	<form id="formobj" action="${ctx}/bus/g_identity_auth/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">认证状态<font color='red'>*</font>：</label>
	        <div class="controls">
		        <select name="g_identity_auth.auth_status">
	        		<option value="1" <c:if test="${item.auth_status==1}"><c:out value='selected="selected"'></c:out></c:if> >未认证</option>		
	        		<option value="2" <c:if test="${item.auth_status==2}"><c:out value='selected="selected"'></c:out></c:if> >认证中</option>		
	        		<option value="3" <c:if test="${item.auth_status==3}"><c:out value='selected="selected"'></c:out></c:if> >已通过认证</option>		
	        		<option value="4" <c:if test="${item.auth_status==4}"><c:out value='selected="selected"'></c:out></c:if> >未通过认证</option>			
		        </select>
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">反馈<font color='red'>*</font>：</label>
		        <div class="controls">
		        	<input name="g_identity_auth.feedback" value="${item.feedback}" class="inputxt" datetype="*1-200" type="text"/>
		        	<%-- <c:if test="${item.auth_status==1}">
		        		<input name="g_identity_auth.feedback" value="您暂时还未认证" class="inputxt" type="text" readonly="readonly"/>
		        	</c:if>
		        	<c:if test="${item.auth_status==2}">
		        		<input name="g_identity_auth.feedback" value="认证中,请耐心等待" class="inputxt" type="text" readonly="readonly"/>
		        	</c:if>
		        	<c:if test="${item.auth_status==3}">
		        		<input name="g_identity_auth.feedback" value="您已经通过认证" class="inputxt" type="text" readonly="readonly"/>
		        	</c:if>
		        	<c:if test="${item.auth_status==4}">
		        		<input name="g_identity_auth.feedback" value="" class="inputxt" datetype="*1-200" type="text"/>
		        	</c:if> --%>
	        	</div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">记录状态<font color='red'>*</font>：</label>
		        <div class="controls">
		        	<select name="g_identity_auth.status">
			        	<c:if test="${item.status == 0}">
			        		<option value="0" selected="selected">正常</option>		
			        		<option value="1">异常</option>		
			        	</c:if>
			        	<c:if test="${item.status == 1}">
			        		<option value="0">正常</option>		
			        		<option value="1" selected="selected">异常</option>		
			        	</c:if>
		       		 </select>
	        	</div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_login_log.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="g_identity_auth.auth_id" value="${item.auth_id}"/>
	</form>
  </body>
</html>
