<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>身份认证详情</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>


</head>
<body>
	<div class="form-horizontal">
		<div class="control-group">
			<label class="control-label Validform_label">用户编号：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.uid}" class="inputxt"
					type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">真实姓名：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.realName}" class="inputxt"
					type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件类型：</label>
			<div class="controls">
				<c:if test="${item.certificateType==1}">
					<input disabled="disabled" value="身份证" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.certificateType==2}">
					<input disabled="disabled" value="护照" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.certificateType==3}">
					<input disabled="disabled" value="军官证" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.certificateType==4}">
					<input disabled="disabled" value="台湾居民通行证" class="inputxt"
						type="text">
				</c:if>
				<c:if test="${item.certificateType==5}">
					<input disabled="disabled" value="港澳居民通行证" class="inputxt"
						type="text">
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件号码：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.certificateNumber}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">是否是认证商家：</label>
			<div class="controls">
				<c:if test="${item.isAuthSupplier == 0}">
					<input disabled="disabled" value="否" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.isAuthSupplier == 1}">
					<input disabled="disabled" value="是" class="inputxt" type="text">
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件背面图片编号：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.reverseImgId}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件背面图片：</label>
			<div class="controls">
				<a href="${item.reverseImgUrl}" target="_blank"><img src="${item.reverseImgPreview}" width="100px"
					height="100px" ></a>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件正面图片编号：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.frontImgId}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件正面图片：</label>
			<div class="controls">
				<a href="${item.frontImgUrl}" target="_blank"><img src="${item.frontImgPreview}" width="100px"
					height="100px"></a>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">手持证件图片编号：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.inHandImgId}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">手持证件图片：</label>
			<div class="controls">
				<a href="${item.inHandImgUrl}" target="_blank"><img src="${item.inHandImgPreview}" width="100px"
					height="100px"></a>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">认证状态：</label>
			<div class="controls">
				<c:if test="${item.authStatus == 1}">
					<input disabled="disabled" value="未认证" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.authStatus == 2}">
					<input disabled="disabled" value="认证中" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.authStatus == 3}">
					<input disabled="disabled" value="已通过认证" class="inputxt"
						type="text">
				</c:if>
				<c:if test="${item.authStatus == 4}">
					<input disabled="disabled" value="未通过认证" class="inputxt"
						type="text">
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">反馈：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.feedback}" class="inputxt"
					type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">记录状态：</label>
			<div class="controls">
				<c:if test="${item.status == 0}">
					<input disabled="disabled" value="正常" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.status == 1}">
					<input disabled="disabled" value="异常" class="inputxt" type="text">
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">备注：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.remark}" class="inputxt"
					type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">创建时间：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.createTime}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">更新时间：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.updatedTime}"
					class="inputxt" type="text">
			</div>
		</div>
	</div>
</body>
</html>
