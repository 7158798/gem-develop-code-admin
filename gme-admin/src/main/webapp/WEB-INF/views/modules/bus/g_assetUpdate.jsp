<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>资产信息修改</title>
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
  	<form id="formobj" action="${ctx}/bus/g_asset/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">资金状态<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="g_asset.status">
	        		<c:if test="${item.status == 0}">
	        			<option value="0" selected="selected">正常</option>
	        			<option value="1">冻结</option>
	        		</c:if>
	        		<c:if test="${item.status == 1}">
	        			<option value="0">正常</option>
	        			<option value="1" selected="selected">冻结</option>
	        		</c:if>
	        	</select>
	        </div>
      	</div>
		<input type="hidden" name="g_asset.asset_id" value="${item.asset_id}"/>
	</form>
  </body>
</html>
