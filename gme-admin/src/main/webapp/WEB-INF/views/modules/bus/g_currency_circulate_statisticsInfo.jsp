<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种流通详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">币种编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种代码：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_symbol}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">价格：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.current_price}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.trade_volume}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">总市值：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.total_value}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">日涨跌：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.daily_change}" class="inputxt" type="text">
	        </div>
      	</div>
  	</div>
  </body>
</html>
