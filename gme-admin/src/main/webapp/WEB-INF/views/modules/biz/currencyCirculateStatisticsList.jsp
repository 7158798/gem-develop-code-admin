<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<title>币种流通统计</title>
	<%@ include file="/WEB-INF/views/include/head.jsp"%>
	<script type="text/javascript">
	  	$(function() {
	  		$('#dataGrid').datagrid({
				url : '${ctx}/biz/currencyCirculateStatistics/list',
				method: 'POST',
				title : '',
				iconCls : '',
				fit : true,
				fitColumns : true,
				pagination : true,
				rownumbers:true,
				pageSize : 20,
				pageList : [ 10,20,30 ],
				nowarp : false,
				border : false,
				idField : 'volumeId',
				sortName : '',
				sortOrder : '',
				remotesort: true,
				singleSelect:true,
				toolbar:'#toolDiv',
				frozenColumns : [ [ {
					title : '编号',
					field : 'volumeId',
					hidden : true
				} ] ],
				columns : [ [ 
					{
						title : '币种编号',
						field : 'currencyId',
						width : 150,
						align : 'center'
					},
					{
						title : '币种代码',
						field : 'currencySymbol',
						width : 150,
						align : 'center'
					},
					{
						title : '价格',
						field : 'currentPrice',
						width : 150,
						align : 'center'
					},
					{
						title : '交易量',
						field : 'tradeVolume',
						width : 150,
						align : 'center'
					},
					{
						title : '总市值',
						field : 'totalValue',
						width : 150,
						align : 'center'
					},
					{
						title : '日涨跌',
						field : 'dailyChange',
						width : 150,
						align : 'center'
					},
				{
					title : '操作',
					field : '_opt',
					align : 'center',
					width : 100,
					formatter:function (value, row, index){
                        var a = '';var b = '';var c = '';
                        var div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a>';
						<shiro:hasPermission name="bus:currencyCirculateStatistics:add">
							a = '<li><a href="javaScript:void(0);" onclick="detail(\'详情\',\'${ctx}/biz/currencyCirculateStatistics/info?id='+row.volumeId+'\',null,null)"><i class="fa fa-info-circle"></i>详情</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:currencyCirculateStatistics:update">
							b = '<li><a href="javaScript:void(0);" onclick="update(\'修改\',\'${ctx}/biz/currencyCirculateStatistics/toUpdate?id='+row.volumeId+'\',\'dataGrid\',null,null);"><i class="fa fa-edit"></i>修改</a></li>';
						</shiro:hasPermission>
						<shiro:hasPermission name="bus:currencyCirculateStatistics:delete">
							c = '<li><a href="javaScript:void(0);" onclick="deleterow('+row.volumeId+')"><i class="fa fa-trash-o"></i>删除</a></li>';
						</shiro:hasPermission>
                        div = '<div class="dropdown-table" data-row="'+index+'"><a class="dropdown-toggle" href="javascript:;"><i class="fa fa-gear"></i></a><ul class="u-menu">' + a + b + c + '</ul></div>';
            			return div;
					}
				}
				] ],
				onClickRow : function(rowIndex, rowData) {
				}
			}).datagrid('getPager').pagination({
				showPageList : true,
				showRefresh : true
			});
	  	});
	  	function reloadTable(){
	  		try{	
				$('#dataGrid').datagrid('reload');	
			}catch(ex){
			}
	  	}
  		function deleterow(id){
            createdialog('删除确认 ', '确定删除该记录吗 ?', '${ctx}/biz/currencyCirculateStatistics/delete?id='+id,'dataGrid');
        }
  		function bustripsearch(){
			var queryParams=$('#dataGrid').datagrid('options').queryParams;
			$('#toolDivNew').find('*').each(function(){
				queryParams[$(this).attr('name')]=$(this).val();
			});
			$('#dataGrid').datagrid({url:'${ctx}/biz/currencyCirculateStatistics/list',pageNumber:1});
		}
		function searchReset(){ 
			$("#toolDivNew").find(":input").val("");bustripsearch();
		}
		function toAdd(){
			add('新增','${ctx}/biz/currencyCirculateStatistics/toAdd','dataGrid',800,500);
		}
	</script>
  </head>
   <body class="psflow-panpel-body">
	  	<table id="dataGrid"></table>
		<div id="toolDiv" style="padding:2px 5px;">
			<div class="psflow-panpel-maintitle">
				<h2 class="psflow-panpel-title"><span>币种流通统计</span></h2>
			</div>
			<div class="psflow-panpel-tooldiv">
				<div class="tooldiv" id="toolDivNew">
		   			<shiro:hasPermission name="bus:currencyCirculateStatistics:view">
		   			<span>币种编号:</span><input type="text" name="currencyCirculateStatisticsVO.currencyId" >
		   			<span>币种代码:</span><input type="text" name="currencyCirculateStatisticsVO.currencySymbol" >
		   			<a href="javaScript:void(0);" class="u-btn" onclick="bustripsearch();"><i class="fa fa-search"></i>查询</a>
	        		<a href="javaScript:void(0);" class="u-btn u-btn-cgray" onclick="searchReset();" ><i class="fa fa-refresh"></i>重置</a>
		   			</shiro:hasPermission>
		   			<shiro:hasPermission name="bus:currencyCirculateStatistics:add">
			      		<a href="javaScript:void(0);" class="u-btn u-btn-cg" plain="true" id="addBtn" onclick="toAdd();"><i class="fa  fa-fw fa-plus"></i>添加</a>
			      	</shiro:hasPermission>
				</div>
			</div>
		</div>
  </body>
</html>
