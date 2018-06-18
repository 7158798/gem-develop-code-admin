<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>OTC订单表（g_otc_order）
功能描述：存储OTC订单信息。
详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">订单号;无重复32位订单号：</label>
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
        	<label class="control-label Validform_label">业务类型:1-买家;2-卖家;：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_type}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">媒介币种：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_id}" class="inputxt" type="text">
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
        	<label class="control-label Validform_label">订单状态：1挂单中;2-全部成交;3-部分成交;4-撤销;5-挂单超时;：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_status}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">注意，解决僵尸单方案：如果遇到最后数量余额小于该字段设置的最小交易数量则自动默认成交,不受该字段限制;：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_min_number}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">支付方式：00-前两位表示是否银行卡支付;00-中间两位表示是否支付宝支付;00-最后两位表示是否微信支付;其中，01表示是;02表示否;：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_pay_type}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">挂单时长限制（单位：小时）默认0表示无限制：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.order_duration}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">备注：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.remark}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.version}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.create_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.updated_time}" class="inputxt" type="text">
	        </div>
      	</div>
  	</div>
  </body>
</html>
