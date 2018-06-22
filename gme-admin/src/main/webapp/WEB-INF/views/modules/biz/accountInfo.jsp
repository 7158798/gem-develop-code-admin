<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户账户信息详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">账号ID：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.accountId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">真实姓名：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.realName}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">银行卡类型：</label>
	        <div class="controls">
	        	<c:if test="${item.cardType == 1}">
	        		<input disabled="disabled" value="借记卡" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.cardType == 2}">
	        		<input disabled="disabled" value="信用卡" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">银行卡号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.cardNumber}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">开户银行：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.bankName}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">开户支行：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.bankBranchName}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">支付宝二维码图片编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.bankBranchName}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">支付宝账号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.alipayAccount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">支付宝绑定描述：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.alipayDesc}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">微信钱包二维码图片编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.wxQrcodeId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">微信账号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.wxAccount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">微信绑定描述：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.wxDesc}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">转账账号：</label>
	        <div class="controls">
	        	<c:if test="${item.auditStatus == 1}">
	        		<input disabled="disabled" value="未审核" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.auditStatus == 2}">
	        		<input disabled="disabled" value="通过审核" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">账户状态：</label>
	        <div class="controls">
	        	<c:if test="${item.accountStatus == 1}">
	        		<input disabled="disabled" value="正常" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.accountStatus == 2}">
	        		<input disabled="disabled" value="冻结" class="inputxt" type="text">
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
