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
	        	<input disabled="disabled" value="${item.pairSn}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易对：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.pairSymbol}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">描述：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.pairDesc}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种表的currencyId：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currencyId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种平台交易手续费：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.serviceCharge}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种表的token_id：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currencyTokenId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">媒介币平台服务手续费：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.tokenServiceCharge}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易价格上限：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.tradeMaxPrice}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易价格下限：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.tradeMinPrice}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">交易数量下限：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.tradeNumberLowerLimit}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否启用：</label>
	        <div class="controls">
	        	<c:if test="${item.isEnable == 0}">
		        	<input disabled="disabled" value="否" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.isEnable == 1}">
	        		<input disabled="disabled" value="是" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否推荐：</label>
	        <div class="controls">
	        	<c:if test="${item.isElite == 0}">
	        		<input disabled="disabled" value="否" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.isElite == 1}">
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
