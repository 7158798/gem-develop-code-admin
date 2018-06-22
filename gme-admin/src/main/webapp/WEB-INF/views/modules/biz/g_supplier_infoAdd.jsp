<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>商家信息表（g_supplier_info）
功能描述：存储商家统计数据信息。新增</title>
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
  	<form id="formobj" action="${ctx}/bus/g_supplier_info/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">商家名称<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.supplier_name" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否认证；1-是;2-否<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.is_auth" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种类型<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.currency_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种符号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.currency_symbol" value="" class="inputxt" datatype="*1-20"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">订单总数<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.total_number" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">总成交数<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.total_deal_number" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">取消次数；每天最多取消三次，超过次数禁止OTC交易（系统撤销订单除外）<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.cancel_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">被投诉次数；投诉5次或以上，禁止OTC交易<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.complained_number" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">保证金<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.deposit" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">被冻结的保证金<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.frozen_deposit" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">商家状态；1-正常;2-冻结;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.supplier_status" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">token生成规则：MD5(key+uid+is_auth+total_number+total_deal_number+cancel_time+complained_number+deposit+frozen_deposit); 程序操作记录行均需要生成token与该字段进行验证<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.token" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.version" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.create_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_supplier_info.updated_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
