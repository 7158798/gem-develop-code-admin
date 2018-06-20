<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>OTC历史订单详情</title>
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
        	<label class="control-label Validform_label">挂单用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">业务类型：</label>
	        <div class="controls">
	        	<c:if test="${item.order_type == 1}">
		        	<input disabled="disabled" value="买家" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.order_type == 2}">
		        	<input disabled="disabled" value="卖家" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">媒介币种：</label>
	        <div class="controls">
	        	<c:if test="${item.currency_id == 1}">
	        		<input disabled="disabled" value="usdt" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.currency_id == 2}">
	        		<input disabled="disabled" value="eos" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">人民币价格：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_price}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">数量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_number}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">总金额：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_amount}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">订单状态：</label>
	        <div class="controls">
	        	<c:if test="${item.order_status == 1}">
	        		<input disabled="disabled" value="挂单中" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.order_status == 2}">
	        		<input disabled="disabled" value="全部成交" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.order_status == 3}">
	        		<input disabled="disabled" value="部分成交" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.order_status == 4}">
	        		<input disabled="disabled" value="撤销" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.order_status == 5}">
	        		<input disabled="disabled" value="挂单超时" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易对象姓名：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.object_uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易对象编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.object_name}" class="inputxt" type="text">
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
