<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>身份认证详情</title>
<%@ include file="/WEB-INF/views/include/head.jsp"%>

<!-- <style type="text/css">
		.show-bigImg{
		  width: 1200/@rem;
		  height: auto;
		  margin: auto;
		  position: fixed;
		  top: 50%;
		  left: 50%;
		}
		.show-bigImg img{
		  max-width: 100%;
		  max-height: 800/@rem;
		}
		.mengceng{
		  position:fixed;
		  left:0;
		  top:0;
		  width:100%;
		  height:100%;
		  background-color: rgba(0,0,0,0.7);
		  display: none;
		}
	</style>    
    <script type="text/javascript">
    	// 点击 查看大图调用对应的函数
    	function a(){
    		
    	}
    
	 	// 给img图片标签添加onClick=“bigImg（this）”事件
	    function bigImg(obj) {
	        var image = new Image(); //创建一个image对象
	        var path = obj.src;
	        image.src=path;   //新创建的image添加src
	        var width = image.width;  // 获取原始图片的宽
	        var hight = image.height; // 获取原始图片高
	        $("#bigImg").attr('src',path); 
	        $(".show-bigImg").css({"margin-top":-hight/2,"margin-left":-width/2});// 居中；css中使用了fixed定位top：50%；left：50%；
	        $(".mengceng").css("display","block");
	        if (width>1200) {
	            $(".show-bigImg").css({"margin-left":-1200/2});
	        }
	        if (hight>800) {
	            $(".show-bigImg").css({"margin-top":-800/2});
	        }
	    }
	    // 点击放大图片关闭
	    function closeImg(obj) {
	        $("#bigImg").attr('src',"");
	        $(".mengceng").css("display","none");
	    }
    </script> -->

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
				<input disabled="disabled" value="${item.real_name}" class="inputxt"
					type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件类型：</label>
			<div class="controls">
				<c:if test="${item.certificate_type==1}">
					<input disabled="disabled" value="身份证" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.certificate_type==2}">
					<input disabled="disabled" value="护照" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.certificate_type==3}">
					<input disabled="disabled" value="军官证" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.certificate_type==4}">
					<input disabled="disabled" value="台湾居民通行证" class="inputxt"
						type="text">
				</c:if>
				<c:if test="${item.certificate_type==5}">
					<input disabled="disabled" value="港澳居民通行证" class="inputxt"
						type="text">
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件号码：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.certificate_number}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">是否是认证商家：</label>
			<div class="controls">
				<c:if test="${item.is_auth_supplier == 0}">
					<input disabled="disabled" value="否" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.is_auth_supplier == 1}">
					<input disabled="disabled" value="是" class="inputxt" type="text">
				</c:if>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件背面图片编号：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.reverse_img_id}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件背面图片：</label>
			<div class="controls">
				<a href="${item.reverse_img_url}" target="_blank"><img alt="reverse" src="${item.reverse_img_preview}" width="100px"
					height="100px" ></a>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件正面图片编号：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.front_img_id}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">证件正面图片：</label>
			<div class="controls">
				<a href="${item.front_img_url}" target="_blank"><img alt="front" src="${item.front_img_preview}" width="100px"
					height="100px"></a>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">手持证件图片编号：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.in_hand_img_id}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">手持证件图片：</label>
			<div class="controls">
				<a href="${item.in_hand_img_url}" target="_blank"><img alt=in_hand src="${item.in_hand_img_preview}" width="100px"
					height="100px"></a>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">认证状态：</label>
			<div class="controls">
				<c:if test="${item.auth_status == 1}">
					<input disabled="disabled" value="未认证" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.auth_status == 2}">
					<input disabled="disabled" value="认证中" class="inputxt" type="text">
				</c:if>
				<c:if test="${item.auth_status == 3}">
					<input disabled="disabled" value="已通过认证" class="inputxt"
						type="text">
				</c:if>
				<c:if test="${item.auth_status == 4}">
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
				<input disabled="disabled" value="${item.create_time}"
					class="inputxt" type="text">
			</div>
		</div>
		<div class="control-group">
			<label class="control-label Validform_label">更新时间：</label>
			<div class="controls">
				<input disabled="disabled" value="${item.updated_time}"
					class="inputxt" type="text">
			</div>
		</div>
	</div>
</body>
</html>
