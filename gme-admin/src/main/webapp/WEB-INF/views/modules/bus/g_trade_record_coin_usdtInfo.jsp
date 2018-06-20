<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>委托交易记录详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">交易类型：</label>
	        <div class="controls">
	        	<c:if test="${item.trade_type == 1}">
		        	<input disabled="disabled" value="买入" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.trade_type == 2}">
		        	<input disabled="disabled" value="卖出" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易对编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.pair_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易对符号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.pair_symbol}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">原始用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.object_uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易日期：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.trade_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易价格：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.trade_price}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单数量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_number}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">金额：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.amount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易状态：</label>
	        <div class="controls">
	        <c:if test="${item.trade_status == 1}">
	        		<input disabled="disabled" value="交易中" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.trade_status == 2}">
	        		<input disabled="disabled" value="已付款" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.trade_status == 3}">
	        		<input disabled="disabled" value="交易成功" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.trade_status == 4}">
	        		<input disabled="disabled" value="交易失败" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.trade_status == 5}">
	        		<input disabled="disabled" value="系统取消" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.trade_status == 6}">
	        		<input disabled="disabled" value="系统放行" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">手续费编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.finance_id}" class="inputxt" type="text">
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
