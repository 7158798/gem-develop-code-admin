<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>工单表（g_work_order）
功能描述：存储工单信息。
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
  	<form id="formobj" action="${ctx}/bus/g_work_order/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">工单ID<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.work_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">工单主题<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.subject" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">工单类型1充值;2提现;3申诉;4仲裁;5其他<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.work_type" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种类型<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.currency_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">业务编号如充值,提现和交易的编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.biz_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">内容编号存储大文本数据表(g_text)的编号 txt_id<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.work_content" value="" class="inputxt" datatype="*1-5000"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">图片编号存储图片文件数据表(g_image_info)的img_id;多张图片使用半角英文分号隔开(;)，最多3张<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.work_img_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">提交用户<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.uid" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">账户ID<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.account_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">手机号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.phone_code" value="" class="inputxt" datatype="*1-20"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">用户名称<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.name" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">提交时间<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.submit_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">处理客服<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.sys_uid" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">客服名称<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.sys_name" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">处理时间<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.finished_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">工单状态1-未处理;2-处理中;3-已处理;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.work_status" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">答复限制往来次数限制<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.reply_limit" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.version" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.create_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.updated_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
