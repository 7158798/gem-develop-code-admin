<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种交易对修改</title>
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
  	<form id="formobj" action="${ctx}/biz/currencyTradePair/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">币种平台交易手续费<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.serviceCharge" value="${item.serviceCharge}" class="inputxt"  datatype="n"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">媒介币平台服务手续费<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.tokenServiceCharge" value="${item.tokenServiceCharge}" class="inputxt"  datatype="n"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易价格上限<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.tradeMaxPrice" value="${item.tradeMaxPrice}" class="inputxt"  datatype="n1-10"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易价格下限<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.tradeMinPrice" value="${item.tradeMinPrice}" class="inputxt"  datatype="n1-10"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">交易数量下限<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.tradeNumberLowerLimit" value="${item.tradeNumberLowerLimit}" class="inputxt"  datatype="n1-10"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否启用<font color='red'>*</font>：</label>
	        <div class="controls">
		        <select name="currencyTradePair.isEnable">
		        	<c:if test="${item.isEnable == 0}">
	   					<option value="0" selected= "selected">否</option>
	   					<option value="1">是</option>
	   				</c:if>
	   				<c:if test="${item.isEnable == 1}">
	   					<option value="0">否</option>	
	   					<option value="1" selected= "selected">是</option>
	   				</c:if>
			   	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否推荐<font color='red'>*</font>：</label>
	        <div class="controls">
	        <select name="currencyTradePair.isElite">
	        	<c:if test="${item.isElite == 0}">
  					<option value="0" selected= "selected">否</option>
  					<option value="1">是</option>
  				</c:if>
  				<c:if test="${item.isElite == 1}">
  					<option value="0">否</option>	
  					<option value="1" selected= "selected">是</option>
	   			</c:if>
		   	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currencyTradePair.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="currencyTradePair.pairId" value="${item.pairId}"/>
	</form>
  </body>
</html>
