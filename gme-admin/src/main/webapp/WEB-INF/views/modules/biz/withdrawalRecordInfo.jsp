<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>提现记录详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">提现单号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.withdrawalId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种类型：</label>
	        <div class="controls">
	        	<c:if test="${item.currencyId == 1}">
		        	<input disabled="disabled" value="USDT" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.currencyId == 2}">
		        	<input disabled="disabled" value="BTC" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.currencyId == 3}">
		        	<input disabled="disabled" value="ETH" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">提现申请数量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.requestAmount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">到账实际数量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.realAmount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">手续费：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.serviceCharge}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">提现状态：</label>
	        <div class="controls">
	        	<c:if test="${item.status == 1}">
		        	<input disabled="disabled" value="申请" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.status == 2}">
		        	<input disabled="disabled" value="处理中" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.status == 3}">
		        	<input disabled="disabled" value="已处理" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.status == 4}">
		        	<input disabled="disabled" value="已拒绝" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.status == 5}">
		        	<input disabled="disabled" value="撤销" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">钱包地址：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.walletAddress}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">处理时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.handleTime}" class="inputxt" type="text">
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
