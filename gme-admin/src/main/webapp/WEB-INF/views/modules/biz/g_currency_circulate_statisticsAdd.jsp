<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种流通统计</title>
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
  	<form id="formobj" action="${ctx}/bus/g_currency_circulate_statistics/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">币种编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency_circulate_statistics.currency_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种代码<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency_circulate_statistics.currency_symbol" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">价格<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency_circulate_statistics.current_price" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency_circulate_statistics.trade_volume" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">总市值<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency_circulate_statistics.total_value" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">日涨跌<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency_circulate_statistics.daily_change" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
