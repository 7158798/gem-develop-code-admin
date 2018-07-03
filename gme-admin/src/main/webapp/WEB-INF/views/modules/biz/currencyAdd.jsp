<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>币种信息新增</title>
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
	
	
	<script type="text/javascript">
		var itemAddEditor ;
		//页面初始化完毕后执行此方法
		$(function(){
			//创建富文本编辑器
			//itemAddEditor = TAOTAO.createEditor("#itemAddForm [name=desc]");
			//itemAddEditor = KindEditor.create("#formobj [name=iconImgUpload]", TT.kingEditorParams);
			itemAddEditor = KindEditor.create("#formobj [name=iconImgUpload]", {
							items:["multiimage"]
							});
			//初始化类目选择和图片上传器
			TAOTAO.init({fun:function(node){
				//根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。
				TAOTAO.changeItemParam(node, "itemAddForm");
			}});
		});
		//提交表单
		/* function submitForm(){
			//有效性验证
			if(!$('#itemAddForm').form('validate')){
				$.messager.alert('提示','表单还未填写完成!');
				return ;
			}
			//取商品价格，单位为“分”
			$("#itemAddForm [name=price]").val(eval($("#itemAddForm [name=priceView]").val()) * 100);
			//同步文本框中的商品描述
			itemAddEditor.sync();
			//取商品的规格
			var paramJson = [];
			$("#itemAddForm .params li").each(function(i,e){
				var trs = $(e).find("tr");
				var group = trs.eq(0).text();
				var ps = [];
				for(var i = 1;i<trs.length;i++){
					var tr = trs.eq(i);
					ps.push({
						"k" : $.trim(tr.find("td").eq(0).find("span").text()),
						"v" : $.trim(tr.find("input").val())
					});
				}
				paramJson.push({
					"group" : group,
					"params": ps
				});
			});
			//把json对象转换成字符串
			paramJson = JSON.stringify(paramJson);
			$("#itemAddForm [name=itemParams]").val(paramJson);
			
			//ajax的post方式提交表单
			//$("#itemAddForm").serialize()将表单序列号为key-value形式的字符串
			$.post("/item/save",$("#itemAddForm").serialize(), function(data){
				if(data.status == 200){
					$.messager.alert('提示','新增商品成功!');
				}
			});
		}
		
		function clearForm(){
			$('#itemAddForm').form('reset');
			itemAddEditor.html('');
		} */
</script>
  </head>
  <body>
  	<form id="formobj" action="${ctx}/biz/currency/add" name="formobj" method="post" class="form-horizontal" enctype="multipart/form-data">
 		<input type="hidden" id="btn_sub" class="btn_sub">
 		<div class="control-group">
        	<label class="control-label Validform_label">币种符号<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currency.currencySymbol" value="" class="inputxt" datatype="*1-20"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种描述<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currency.currencyDesc" value="" class="inputxt" datatype="*1-500"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">币种图标<font color='red'>*</font>：</label>
	        	<input name="iconImgUpload" type="file"/>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">中文名<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currency.nameCN" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">英文名<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currency.nameEN" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否是媒介币<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="currency.isToken">
	        		<option value="0">不是</option>
	        		<option value="1">是</option>
	        	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">操作者<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currency.operatorName" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">是否充值或者提现<font color='red'>*</font>：</label>
	        <div class="controls">
   				充值<input type="checkbox" name="currency.isOpen" value="0102"><br/>
	        	提现<input type="checkbox" name="currency.isOpen" value="0201">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">启用/冻结<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<select name="currency.isEnable">
	        		<option value="1">启用</option>
	        		<option value="2">冻结</option>
	        	</select>
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">发行量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currency.supply" value="" class="inputxt" datatype="n1-16"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">流通总量<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currency.circulation" value="" class="inputxt" datatype="n1-16"  type="text">
	        </div>
      	</div>
 		<div class="control-group">
        	<label class="control-label Validform_label">备注<font color='red'>*</font>：</label>
	        <div class="controls">
	        	<input name="currency.remark" value="" class="inputxt" datatype="*1-50"  type="text">
	        </div>
      	</div>
	</form>
  </body>
</html>
