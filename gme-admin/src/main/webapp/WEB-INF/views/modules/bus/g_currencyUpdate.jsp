<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种表</title>
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
  	<form id="formobj" action="${ctx}/bus/g_currency/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">币种符号<font color='red'>*</font>：</label>
	        <div class="controls">
	       	 	<input name="g_currency.currency_symbol" value="${item.currency_symbol}" class="inputxt"  datatype="*1-20"  type="text">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">币种描述<font color='red'>*</font>：</label>
	        <div class="controls">
	       	 	<input name="g_currency.currency_desc" value="${item.currency_desc}" class="inputxt"  datatype="*1-500"  type="text">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">币种图标<font color='red'>*</font>：</label>
	        <div class="controls">
	       	 	<input name="g_currency.icon_id" value="${item.icon_id}" class="inputxt"  datatype="*1-36"  type="text">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">中文名<font color='red'>*</font>：</label>
	        <div class="controls">
	       	 	<input name="g_currency.name_cn" value="${item.name_cn}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
      	<div class="control-group">
        	<label class="control-label Validform_label">英文名<font color='red'>*</font>：</label>
	        <div class="controls">
	       	 	<input name="g_currency.name_en" value="${item.name_en}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否是媒介币<font color='red'>*</font>：</label>
	        <div class="controls">
	       	 	<select name="g_currency.is_token">
		        	<c:if test="${item.is_token == 0}">
	   					<option value="0" selected= "selected">不是</option>
	   					<option value="1">是</option>
	   				</c:if>
	   				<c:if test="${item.is_token == 1}">
	   					<option value="0">不是</option>	
	   					<option value="1" selected= "selected">是</option>
	   				</c:if>
			   	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否充值或者提现<font color='red'>*</font>：</label>
	        <div class="controls">
	        		<c:if test="${item.is_open == 0202}">
	   					充值<input type="checkbox" name="g_currency.is_open" value="0102"><br/>
		        		提现<input type="checkbox" name="g_currency.is_open" value="0201">
	   				</c:if>
		        	<c:if test="${item.is_open == 0102}">
		        		充值<input type="checkbox" name="g_currency.is_open" value="0102" checked="checked"><br/>
		        		提现<input type="checkbox" name="g_currency.is_open" value="0201">
	   				</c:if>
	   				<c:if test="${item.is_open == 0201}">
	   					充值<input type="checkbox" name="g_currency.is_open" value="0102"><br/>
		        		提现<input type="checkbox" name="g_currency.is_open" value="0201"  checked="checked">
	   				</c:if>
	   				<c:if test="${item.is_open == 0101}">
	   					充值<input type="checkbox" name="g_currency.is_open" value="0102" checked="checked"><br/>
		        		提现<input type="checkbox" name="g_currency.is_open" value="0201"  checked="checked">
	   				</c:if>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种状态<font color='red'>*</font>：</label>
	        <div class="controls">
	        <select name="g_currency.is_enable">
		        	<c:if test="${item.is_enable == 1}">
	   					<option value="1" selected= "selected">启用</option>
	   					<option value="2">冻结</option>
	   				</c:if>
	   				<c:if test="${item.is_enable == 2}">
	   					<option value="1">启用</option>	
	   					<option value="2" selected= "selected">冻结</option>
	   				</c:if>
			   	</select>
	        </div>
      	</div>
      		<div class="control-group">
        	<label class="control-label Validform_label">发行量<font color='red'>*</font>：</label>
	        <div class="controls">
	       	 	<input name="g_currency.supply" value="${item.supply}" class="inputxt"  datatype="n1-16"  type="text">
	        </div>
      	</div>
      		<div class="control-group">
        	<label class="control-label Validform_label">流通总量<font color='red'>*</font>：</label>
	        <div class="controls">
	       	 	<input name="g_currency.circulation" value="${item.circulation}" class="inputxt"  datatype="n1-16"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_currency.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="g_currency.currency_id" value="${item.currency_id}" readonly="readonly"/>
	</form>
  </body>
</html>
