<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>委托单历史订单表（g_entrust_order_record_usdt）
功能描述：存储币币交易的委托单历史记录。
新增</title>
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
  	<form id="formobj" action="${ctx}/bus/g_entrust_order_record_usdt/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">无重复32位订单号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.order_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">下单用户编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.uid" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种交易对表（g_currency_trade_pair）<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.pair_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">1-买入;2-卖出;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.entrust_type" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">委托下单日期 / 格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.order_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">这个价格就是USDT的价格<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.entrust_price" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易币种的挂单量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.entrust_amount" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">已成交数量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.finished_amount" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">未成交数量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.unfinished_amount" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">1完全成交;2-部分成交;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.deal_status" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">订单状态：1挂单中;2-已完成;3-未成交;4-撤销;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.order_status" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">订单完成时间<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.order_finished_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.version" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.create_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_entrust_order_record_usdt.updated_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
