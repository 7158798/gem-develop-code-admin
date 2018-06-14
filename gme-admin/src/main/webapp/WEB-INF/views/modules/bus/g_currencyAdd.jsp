<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种新增</title>
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
  	<form id="formobj" action="${ctx}/bus/g_currency/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">币种符号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.currency_symbol" value="" class="inputxt" datatype="*1-20"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种描述<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.currency_desc" value="" class="inputxt" datatype="*1-500"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种图标<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.icon_id" value="" class="inputxt" datatype="*1-36"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">中文名<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.name_cn" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">英文名<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.name_en" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">启用日期<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.enable_time" value="" class="Wdate" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否是媒介币<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="g_currency.is_token">
  					<option value="1">是</option>
  					<option value="0">否</option>
			   	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否充值或者提现<font color='red'>*</font>：</label>
	        <div class="controls">
	        	充值<input type="checkbox" name="g_currency.is_open" value="0102"><br/>
	        	提现<input type="checkbox" name="g_currency.is_open" value="0201">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种状态<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="g_currency.is_enable">
  					<option value="1">启用</option>
  					<option value="2">冻结</option>
			   	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">发行量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.supply" value="" class="inputxt" datatype="n1-18"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">流通总量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.circulation" value="" class="inputxt" datatype="n1-18"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
