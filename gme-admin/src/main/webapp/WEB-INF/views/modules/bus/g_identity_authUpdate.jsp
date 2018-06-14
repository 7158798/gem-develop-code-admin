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
        	<label class="control-label Validform_label">证件类型<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="g_identity_auth.certificate_type">
	        		<c:if test="${item.certificate_type==1}">
		        		<option value="1" selected="selected">身份证</option>
		        		<option value="2">护照</option>		
		        		<option value="3">军官证</option>		
		        		<option value="4">台湾居民通行证</option>		
		        		<option value="5">港澳居民通行证</option>		
	        		</c:if>
	        		<c:if test="${item.certificate_type==2}">
		        		<option value="1">身份证</option>
		        		<option value="2" selected="selected">护照</option>		
		        		<option value="3">军官证</option>		
		        		<option value="4">台湾居民通行证</option>		
		        		<option value="5">港澳居民通行证</option>		
	        		</c:if>
	        		<c:if test="${item.certificate_type==3}">
		        		<option value="1">身份证</option>
		        		<option value="2">护照</option>		
		        		<option value="3" selected="selected">军官证</option>		
		        		<option value="4">台湾居民通行证</option>		
		        		<option value="5">港澳居民通行证</option>		
	        		</c:if>
	        		<c:if test="${item.certificate_type==4}">
		        		<option value="1">身份证</option>
		        		<option value="2">护照</option>		
		        		<option value="3">军官证</option>		
		        		<option value="4" selected="selected">台湾居民通行证</option>		
		        		<option value="5">港澳居民通行证</option>		
	        		</c:if>
	        		<c:if test="${item.certificate_type==5}">
		        		<option value="1">身份证</option>
		        		<option value="2">护照</option>		
		        		<option value="3">军官证</option>		
		        		<option value="4">台湾居民通行证</option>		
		        		<option value="5" selected="selected">港澳居民通行证</option>		
	        		</c:if>
	        	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否是认证商家<font color='red'>*</font>：</label>
	        <div class="controls">
	        <select name="g_identity_auth.is_auth_supplier">
	        	<c:if test="${item.is_auth_supplier==0}">
	        		<option value="0" selected="selected">否</option>		
	        		<option value="1">是</option>		
	        	</c:if>
	        	<c:if test="${item.is_auth_supplier==1}">
	        		<option value="0">否</option>		
	        		<option value="1" selected="selected">是</option>		
	        	</c:if>
	        </select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">认证状态<font color='red'>*</font>：</label>
	        <div class="controls">
		        <select name="g_identity_auth.auth_status">
		        	<c:if test="${item.auth_status==1}">
		        		<option value="1" selected="selected">未认证</option>		
		        		<option value="2">认证中</option>		
		        		<option value="3">已通过认证</option>		
		        		<option value="4">未通过认证</option>		
		        	</c:if>
		        	<c:if test="${item.auth_status==2}">
		        		<option value="1">未认证</option>		
		        		<option value="2" selected="selected">认证中</option>		
		        		<option value="3">已通过认证</option>		
		        		<option value="4">未通过认证</option>			
		        	</c:if>
		        	<c:if test="${item.auth_status==3}">
		        		<option value="1">未认证</option>		
		        		<option value="2">认证中</option>		
		        		<option value="3" selected="selected">已通过认证</option>		
		        		<option value="4">未通过认证</option>	
		        	</c:if>
		        	<c:if test="${item.auth_status==4}">
		        		<option value="1">未认证</option>		
		        		<option value="2">认证中</option>		
		        		<option value="3">已通过认证</option>		
		        		<option value="4" selected="selected">未通过认证</option>			
		        	</c:if>
		        </select>
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">反馈<font color='red'>*</font>：</label>
		        <div class="controls">
		        	<c:if test="${item.auth_status==1}">
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
		        	</c:if>
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
		<input type="hidden" name="g_identity_auth.auth_id" value="${item.auth_id}"/>
	</form>
  </body>
</html>
