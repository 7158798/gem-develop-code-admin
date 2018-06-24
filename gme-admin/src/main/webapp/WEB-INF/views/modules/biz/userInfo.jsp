<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户信息详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">用户名称：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.name}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">国家：</label>
	        <div class="controls">
	       		<c:if test="${item.countryCode == 86}">
	       			<input disabled="disabled" value="中国" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.countryCode == 1}">
	       			<input disabled="disabled" value="美国" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.countryCode == 60}">
	       			<input disabled="disabled" value="马来西亚" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">用户手机：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.phoneCode}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">用户邮箱：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.mail}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否是商户：</label>
	        <div class="controls">
	        	<c:if test="${item.isSupplier == 0}">
	        		<input disabled="disabled" value="不是" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.isSupplier == 1}">
	        		<input disabled="disabled" value="是" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">最后登录时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.lastLoginTime}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否修改过密码：</label>
	        <div class="controls">
	        	<c:if test="${item.isChangePassword == 0}">
	        		<input disabled="disabled" value="未修改" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.isChangePassword == 1}">
	        		<input disabled="disabled" value="已修改" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">连续输错密码的次数：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.passwordInputErrorCount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">推广码：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.promoCode}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">用户状态：</label>
	        <div class="controls">
	        	<c:if test="${item.status == 1}">
	        		<input disabled="disabled" value="正常" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.status == 2}">
	        		<input disabled="disabled" value="冻结" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否开启二次验证：</label>
	        <div class="controls">
	       		<c:if test="${item.isSecondVerify == 1}">
	        		<input disabled="disabled" value="否" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.isSecondVerify == 2}">
	        		<input disabled="disabled" value="是" class="inputxt" type="text">
	        	</c:if>
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
