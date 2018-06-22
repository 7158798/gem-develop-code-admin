<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>账户新增</title>
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
  	<form id="formobj" action="${ctx}/biz/account/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">账号ID；用户账号ID，全局唯一<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.account_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">真实姓名<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.real_name" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">银行卡类型；1-借记卡;2-信用卡;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.card_type" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">银行卡号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.card_number" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">开户银行<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.bank_name" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">开户支行<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.bank_branch_name" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">支付宝二维码图片编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.alipay_qrcode_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">支付宝账号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.alipay_account" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">支付宝绑定描述<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.alipay_desc" value="" class="inputxt" datatype="*1-300"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">微信钱包二维码图片编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.wx_qrcode_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">微信账号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.wx_account" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">微信绑定描述<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.wx_desc" value="" class="inputxt" datatype="*1-300"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">转账账号1-未审核;2-通过审核;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.audit_status" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">账户状态1-正常;2-冻结;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.account_status" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">token生成规则：MD5(key+uid+account_id+card_number+alipay_qrcode_id+alipay_account+wx_qrcode_id+wx_account+audit_status); 程序操作记录行均需要生成token与该字段进行验证<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.token" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.version" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.create_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="account.updatedTime" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
