<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>商家信息详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">商家名称：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.supplier_name}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否认证：</label>
	        <div class="controls">
	        	<c:if test="${item.is_auth == 1}">
		        	<input disabled="disabled" value="是" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.is_auth == 2}">
		        	<input disabled="disabled" value="否" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否是媒介币：</label>
	        <div class="controls">
	        	<c:if test="${item.is_token == 0}">
		        	<input disabled="disabled" value="不是" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.is_token == 1}">
		        	<input disabled="disabled" value="是" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种符号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_symbol}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单总数：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.total_number}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">总成交数：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.total_deal_number}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">取消次数：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.cancel_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">被投诉次数：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.complained_number}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">保证金：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.deposit}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">被冻结的保证金：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.frozen_deposit}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">商家状态：</label>
	        <div class="controls">
	       		<c:if test="${item.supplier_status == 1}">
		        	<input disabled="disabled" value="正常" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.supplier_status == 2}">
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
