<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>OTC订单详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">订单号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.orderId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">挂单用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">业务类型：</label>
	        <div class="controls">
	        	<c:if test="${item.orderType == 1}">
		        	<input disabled="disabled" value="买家" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.orderType == 2}">
		        	<input disabled="disabled" value="卖家" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种符号：</label>
	        <div class="controls">
        		<input disabled="disabled" value="${item.currencySymbol}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">人民币价格：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.orderPrice}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">数量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.orderNumber}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">总金额：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.orderAmount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单状态：</label>
	        <div class="controls">
	          	<c:if test="${item.orderStatus == 1}">
	        		<input disabled="disabled" value="挂单中" class="inputxt" type="text">
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
	        	<c:if test="${item.orderStatus == 5}">
	        		<input disabled="disabled" value="挂单超时" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单最小金额：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.orderMinNumber}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">支付方式：</label>
	        <div class="controls">
		        <c:if test="${item.orderPayType == '010202'}">
		       		<input disabled="disabled" value="银行卡" class="inputxt" type="text">
		        </c:if>
		        <c:if test="${item.orderPayType == '010102'}">
		       		<input disabled="disabled" value="银行卡|支付宝" class="inputxt" type="text">
		        </c:if>
		        <c:if test="${item.orderPayType == '010201'}">
		       		<input disabled="disabled" value="银行卡|微信" class="inputxt" type="text">
		        </c:if>
		        <c:if test="${item.orderPayType == '010101'}">
		       		<input disabled="disabled" value="银行卡|支付宝|微信" class="inputxt" type="text">
		        </c:if>
		         <c:if test="${item.orderPayType == '020102'}">
		       		<input disabled="disabled" value="支付宝" class="inputxt" type="text">
		        </c:if>
		         <c:if test="${item.orderPayType == '020101'}">
		       		<input disabled="disabled" value="支付宝|微信" class="inputxt" type="text">
		        </c:if>
		        <c:if test="${item.orderPayType == '020201'}">
		       		<input disabled="disabled" value="微信" class="inputxt" type="text">
		        </c:if>
		         <c:if test="${item.orderPayType == '020202'}">
		       		<input disabled="disabled" value="暂无" class="inputxt" type="text">
		        </c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">挂单时长限制：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.orderDuration}" class="inputxt" type="text">
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
