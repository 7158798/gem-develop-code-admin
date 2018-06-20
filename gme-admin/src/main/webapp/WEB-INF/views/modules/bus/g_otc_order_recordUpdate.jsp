<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>OTC历史订单表（g_otc_order_record）修改</title>
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
  	<form id="formobj" action="${ctx}/bus/g_otc_order_record/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">订单号;无重复32位订单号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.order_id" value="${item.order_id}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">挂单用户编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.uid" value="${item.uid}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">业务类型:1-买家;2-卖家;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.order_type" value="${item.order_type}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">媒介币种<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.currency_id" value="${item.currency_id}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">人民币价格<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.order_price" value="${item.order_price}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.order_number" value="${item.order_number}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">总金额<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.order_amount" value="${item.order_amount}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">订单状态：1挂单中;2-全部成交;3-部分成交;4-撤销;5-挂单超时;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.order_status" value="${item.order_status}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易对象姓名<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.object_uid" value="${item.object_uid}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易对象编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.object_name" value="${item.object_name}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.version" value="${item.version}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.create_time" value="${item.create_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_otc_order_record.updated_time" value="${item.updated_time}" class="inputxt"  datatype="*1-"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="g_otc_order_record.entry_order_id" value="${item.entry_order_id}"/>
	</form>
  </body>
</html>
