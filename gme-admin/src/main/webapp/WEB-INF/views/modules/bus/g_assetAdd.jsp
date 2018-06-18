<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>资产表（g_asset）
功能描述：存储用户币种资产信息。新增</title>
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
  	<form id="formobj" action="${ctx}/bus/g_asset/add" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">用户编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.uid" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">账号ID；用户账号ID，全局唯一<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.account_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.currency_id" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">总资产<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.total_assets" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">可用资产<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.usable_assets" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">冻结资产<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.frozen_assets" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">0-正常;1-冻结;<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.status" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">token生成规则：MD5(key+uid+account_id+currency_id+total_assets+<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.token" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.version" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.create_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_asset.updated_time" value="" class="inputxt" datatype="*1-"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
