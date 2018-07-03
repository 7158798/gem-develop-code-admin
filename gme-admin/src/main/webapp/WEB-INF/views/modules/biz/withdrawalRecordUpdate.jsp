<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>提现记录修改</title>
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
  	<form id="formobj" action="${ctx}/biz/withdrawalRecord/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">提现状态<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="withdrawalRecord.status">
        			<option value="1" <c:if test="${item.status == 1}"><c:out value='selected="selected"'></c:out></c:if> >申请</option>
        			<option value="2" <c:if test="${item.status == 2}"><c:out value='selected="selected"'></c:out></c:if> >处理中</option>
        			<option value="3" <c:if test="${item.status == 3}"><c:out value='selected="selected"'></c:out></c:if> >已处理</option>
        			<option value="4" <c:if test="${item.status == 4}"><c:out value='selected="selected"'></c:out></c:if> >已拒绝</option>
        			<option value="5" <c:if test="${item.status == 5}"><c:out value='selected="selected"'></c:out></c:if> >撤销</option>
	        	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="withdrawalRecord.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="withdrawalRecord.id" value="${item.id}"/>
	</form>
  </body>
</html>
