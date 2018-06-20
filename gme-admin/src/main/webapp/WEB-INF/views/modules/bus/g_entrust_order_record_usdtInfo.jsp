<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>委托单历史订单详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">订单号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">下单用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种交易对编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.pair_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易类型：</label>
	        <div class="controls">
	        	<c:if test="${item.entrust_type == 1}">
		        	<input disabled="disabled" value="买入" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.entrust_type == 2}">
		        	<input disabled="disabled" value="卖出" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">委托下单日期 ：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">价格(USDT)：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.entrust_price}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易币种的挂单量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.entrust_amount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">已成交数量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.finished_amount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">未成交数量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.unfinished_amount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易状态：</label>
	        <div class="controls">
	        	<c:if test="${item.deal_status == 1}">
		        	<input disabled="disabled" value="完全成交" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.deal_status == 2}">
		        	<input disabled="disabled" value="部分成交" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单状态：</label>
	        <div class="controls">
	        	<c:if test="${item.order_status == 1}">
		        	<input disabled="disabled" value="挂单中" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.order_status == 2}">
		        	<input disabled="disabled" value="-已完成" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.order_status == 3}">
		        	<input disabled="disabled" value="未成交" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.order_status == 4}">
		        	<input disabled="disabled" value="撤销" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单完成时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_finished_time}" class="inputxt" type="text">
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
	        	<input disabled="disabled" value="${item.create_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">更新时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.updated_time}" class="inputxt" type="text">
	        </div>
      	</div>
  	</div>
  </body>
</html>
