<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>工单修改</title>
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
  	<form id="formobj" action="${ctx}/bus/g_work_order/update" name="formobj" method="post" class="form-horizontal">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">处理客服编号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.sys_uid" value="${item.sys_uid}" class="inputxt"  datatype="n1-36"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">客服名称<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.sys_name" value="${item.sys_name}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">工单状态<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name = "g_work_order.work_status">
	        		<c:if test="${item.work_status == 1}">
	        			<option value="1" selected="selected">未处理</option>
	        			<option value="2">处理中</option>
	        			<option value="3">已处理</option>
	        		</c:if>
	        		<c:if test="${item.work_status == 2}">
	        			<option value="1">未处理</option>
	        			<option value="2" selected="selected">处理中</option>
	        			<option value="3">已处理</option>
	        		</c:if>
	        		<c:if test="${item.work_status == 3}">
	        			<option value="1">未处理</option>
	        			<option value="2">处理中</option>
	        			<option value="3" selected="selected">已处理</option>
	        		</c:if>
	        	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="g_work_order.remark" value="${item.remark}" class="inputxt"  datatype="*1-50"  type="text">
	        </div>
      	</div>
		<input type="hidden" name="g_work_order.subject_id" value="${item.subject_id}"/>
	</form>
  </body>
</html>
