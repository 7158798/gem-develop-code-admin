<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种交易对新增</title>
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
  	<form id="formobj" action="${ctx}/biz/currencyTradePair/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">交易对 如：ltc_usdt<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.pairSymbol" value="" class="inputxt" datatype="*1-20"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">描述<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.pairDesc" value="" class="inputxt" datatype="*1-200"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种平台交易手续费<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.serviceCharge" value="0.002" datatype="n1-10" class="inputxt" type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">媒介币平台服务手续费<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.tokenServiceCharge" value="0.002" datatype="n1-10" class="inputxt"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易价格上限<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.tradeMaxPrice" value="" class="inputxt" datatype="n1-10"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易价格下限<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.tradeMinPrice" value="" class="inputxt" datatype="n1-10"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易数量下限<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.tradeNumberLowerLimit" value="" class="inputxt" datatype="n1-10"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否启用<font color='red'>*</font>：</label>
	        <div class="controls">
	         	<select name="currencyTradePair.isEnable">
   					<option value="1">是</option>
   					<option value="0">否</option>
			   	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否推荐<font color='red'>*</font>：</label>
	        <div class="controls">
	         	<select name="currencyTradePair.isElite">
   					<option value="1">是</option>
   					<option value="0">否</option>
			   	</select>
	        </div>
	        </div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
