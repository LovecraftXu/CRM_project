<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.briup.crm.common.bean.SalPlan"%>
<%@page import="com.github.pagehelper.PageInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>jb-aptech毕业设计项目</title>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script src="js/changetrcolor.js"
	type="text/javascript"></script>
<script type="text/javascript">
function queryPlan(){
	$("#queryform").submit();
}

</script>
</head>
<body>
  <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<TD class="page_title">客户开发计划</TD>
			<TD class="page_title_middle">&nbsp;</TD>
			<TD width=3><IMG height=32
				src="images/m_mpr.gif" width=3></TD>
		</tr>
	</table>
	<form
		action="sale/select_plan"
		method="post" id="queryform">
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<th>计划内容</th>
				<td><input type="text" name="plaTodo" /></td>
				<th>结果</th>
				<td><input type="text" name="plaResult" size="20" /></td>
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="help"><input
						class="common_button" type="button" value="帮助"></a>
						&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp; 
					<button class="common_button" 
					onClick="queryPlan()">查询</button>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
	<tr>
		<TD class="page_title">检索结果</TD>
		<TD class="page_title_middle">&nbsp;</TD>
		<TD width=3><IMG height=32
			src="images/m_mpr.gif" width=3></TD>
	</tr>
	</table>

	<table id="data_list_table" class="data_list_table" cellSpacing=1
		cellPadding=1>
		<tr>
			<th id="firstth">编号</th>
			<th>客户编号</th>
			<th>计划内容</th>
			<th>结果</th>
			<th>操作</th>
			<th>查看</th>
		</tr>
		<c:forEach	items="${pageInfoList.list }" var="salP" >
				<tr align="center">
					<td class="list_data_number">${salP.plaId }</td>
					<td class="list_data_text">${salP.plaChcId }</td>
					<td class="list_data_ltext">${salP.plaTodo }</td>
					<td class="list_data_text">${salP.plaResult }</td>

					<td class="list_data_op"><a
						href="sale/add_salplan"><img
							title="制定计划"
							src="images/bt_plan.gif"
							class="op_button" /></a> 
					</td>
					
					<td class="list_data_op"><img
					onClick="to('sale/watch/${salP.plaId}');"
					title="查看"
					src="images/bt_detail.gif"
					class="op_button" /></td>
				</tr>
		</c:forEach>
					<!-- <tr>
						<td class="list_data_number"></td>
						<td class="list_data_text"></td>
						<td class="list_data_ltext"></td>
						<td class="list_data_text"></td>
						<td class="list_data_text"></td>
						<td class="list_data_text"></td>

						<td class="list_data_op"><img
								onClick="to('dev_detail');"
								title="查看"
								src="images/bt_detail.gif"
								class="op_button" /></td>
					</tr> -->

		<tr>
			<th colspan="100" class="pager">共${pageInfoList.total }条记录 每页 ${pageInfoList.pageSize } 条 
			第${pageInfoList.pageNum }页 
			<a href="sale/dev/1">首页</a>
			<c:choose>
				<c:when test="${sessionScope.pageInfoList.hasPreviousPage }">
					<a href="sale/dev/${pageInfoList.prePage }">上一页</a>
				</c:when>
				<c:otherwise>
					<font color="#ABA8AB">上一页</font>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.pageInfoList.hasNextPage }">
					<a href="sale/dev/${pageInfoList.nextPage }">下一页</a>
				</c:when>
				<c:otherwise>
					<font color="#ABA8AB">下一页</font>
				</c:otherwise>
			</c:choose>
				 <a href="sale/dev/${sessionScope.pageInfoList.pages }">尾页</a>
			</th>
		</tr>
	</table>
</body>
</html>