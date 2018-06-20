<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>OTC交易记录表（g_trade_record_otc_usdt）修改</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>  
	<script type="text/javascript">
	  $(function(){$("#formobj").Validform({
		  tiptype:4,
		  btnSubmit:"#btn_sub",
		  btnReset:"#btn_reset",
		  ajaxPost:true,
		  callback:function(data){
		   var win = frameElement.api.opener;
		   if(data.success==true){
			  frameElement.api.close();win.tip(data.msg);
		   }else{
		   	  tip(data.msg);
			  return false;
		   }
		   win.reloadTable();
		 }
		});});
	</script>
  </head>
  <body>
  	<form id="formobj" action="${ctx}/bus/g_trade_record_otc_usdt/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">交易类型1-买；2-卖<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.trade_type" value="${item.trade_type}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种编号币币交易交易对<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.currency_id" value="${item.currency_id}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种符号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.currency_symbol" value="${item.currency_symbol}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">订单编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.order_id" value="${item.order_id}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">原始用户编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.object_uid" value="${item.object_uid}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易日期<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.trade_time" value="${item.trade_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易价格<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.trade_price" value="${item.trade_price}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">订单数量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.order_number" value="${item.order_number}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">金额<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.amount" value="${item.amount}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易状态1-交易中;2-已付款;3-交易成功(放行);4-交易失败;5-系统取消;6-系统放行;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.trade_status" value="${item.trade_status}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易用户编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.uid" value="${item.uid}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">手续费编号存储平台财务表（g_finance）的finance_id<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.finance_id" value="${item.finance_id}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.version" value="${item.version}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.create_time" value="${item.create_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_trade_record_otc_usdt.updated_time" value="${item.updated_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="g_trade_record_otc_usdt.id" value="${item.id}"/>
	</form>
  </body>
</html>
