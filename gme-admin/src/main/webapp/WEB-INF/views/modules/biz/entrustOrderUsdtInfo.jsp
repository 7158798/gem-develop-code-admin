<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>委托订单详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">委托单号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.orderId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易对编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.pairId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易类型：</label>
	        <div class="controls">
	        	<c:if test="${item.entrustType == 1}">
		        	<input disabled="disabled" value="买入" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.entrustType == 2}">
		        	<input disabled="disabled" value="卖出" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">下单日期：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.orderTime}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">价格(USDT)：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.entrustPrice}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易币种的挂单量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.entrustAmount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">已成交数量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.finishedAmount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">未成交数量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.unfinishedAmount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单状态：</label>
	        <div class="controls">
	        	<c:if test="${item.orderStatus == 1}">
		        	<input disabled="disabled" value="委托中" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.orderStatus == 2}">
		        	<input disabled="disabled" value="全部成交" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.orderStatus == 3}">
		        	<input disabled="disabled" value="部分成交" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.orderStatus == 4}">
		        	<input disabled="disabled" value="撤销" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单完成日期：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.orderFinishedTime}" class="inputxt" type="text">
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
