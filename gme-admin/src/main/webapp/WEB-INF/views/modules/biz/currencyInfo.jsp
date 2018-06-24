<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种表</title>
    <%@ include file="/WEB-INF/views/include/head.jsp"%>  
  </head>
  <body>
  	<div class="form-horizontal">
  		<div class="control-group">
        	<label class="control-label Validform_label">顺序号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currencySn}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种符号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currencySymbol}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种描述：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currencyDesc}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种图标：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.iconId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">中文名：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.nameCN}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">英文名：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.nameEN}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">启用日期：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.enableTime}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否是媒介币：</label>
	        <div class="controls">
		        <c:if test="${item.isToken} == 0">
		        	<input disabled="disabled" value="不是" class="inputxt" type="text">
		        </c:if>
		        <c:if test="${item.isToken} == 1">
		        	<input disabled="disabled" value="是" class="inputxt" type="text">
		        </c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">操作者编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.operatorUid}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">操作者：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.operatorName}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">提现配置编号：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.currencyConfigId}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">是否是充值或者提现：</label>
	        <div class="controls">
	        	<c:if test="${item.isOpen == '0202'}">
		        	<input disabled="disabled" value="" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.isOpen == '0102'}">
		        	<input disabled="disabled" value="充值" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.isOpen == '0201'}">
	        		<input disabled="disabled" value="提现" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.isOpen == '0101'}">
	        		<input disabled="disabled" value="充值&提现" class="inputxt" type="text">
	        	</c:if>
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">币种状态：</label>
	        <div class="controls">
	        	<c:if test="${item.isEnable == 1}">
	        		<input disabled="disabled" value="启用" class="inputxt" type="text">
	        	</c:if>
	        	<c:if test="${item.isEnable == 2}">
	        	<input disabled="disabled" value="冻结" class="inputxt" type="text">
	        	</c:if>
	        	
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">发行量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.supply}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">流通总量：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.circulation}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">备注：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.remark}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">创建时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.createTime}" class="inputxt" type="text">
	        </div>
      	</div>
  		<div class="control-group">
        	<label class="control-label Validform_label">更新时间：</label>
	        <div class="controls">
	        	<input disabled="disabled" value="${item.updatedTime}" class="inputxt" type="text">
	        </div>
      	</div>
  	</div>
  </body>
</html>
