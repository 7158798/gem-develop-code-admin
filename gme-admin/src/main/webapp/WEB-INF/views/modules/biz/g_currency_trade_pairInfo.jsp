<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种交易对详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">交易对顺序号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.pair_sn}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易对：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.pair_symbol}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">描述：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.pair_desc}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种表的currency_id：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种平台交易手续费：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.service_charge}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种表的token_id：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_token_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">媒介币平台服务手续费：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.token_service_charge}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易价格上限：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.trade_max_price}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易价格下限：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.trade_min_price}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易数量下限：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.trade_number_lower_limit}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否启用：</label>
	        <div class="controls">
	        	<c:if test="${item.is_enable == 0}">
		        	<input disabled="disabled" value="否" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.is_enable == 1}">
	        		<input disabled="disabled" value="是" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否推荐：</label>
	        <div class="controls">
	        	<c:if test="${item.is_elite == 0}">
	        		<input disabled="disabled" value="否" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.is_elite == 1}">
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
