<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>资产表（g_asset）
功能描述：存储用户币种资产信息。详情</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">用户编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.uid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">账号ID；用户账号ID，全局唯一：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.account_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currency_id}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">总资产：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.total_assets}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">可用资产：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.usable_assets}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">冻结资产：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.frozen_assets}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">0-正常;1-冻结;：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.status}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">token生成规则：MD5(key+uid+account_id+currency_id+total_assets+：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.token}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">备注：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.remark}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">数据表版本,默认1：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.version}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">创建时间格式:yyyy-MM-dd HH:ss:mm：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.create_time}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">更新时间格式:yyyy-MM-dd HH:ss:mm：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.updated_time}" class="inputxt" type="text">
	        </div>
      	</div>
  	</div>
  </body>
</html>
