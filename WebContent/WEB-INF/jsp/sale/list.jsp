<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.briup.crm.common.bean.SalChance"%>
<%@page import="com.github.pagehelper.PageInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>jb-aptech毕业设计项目</title>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="script/common.js"></script>
<script src="js/changetrcolor.js" type="text/javascript"></script>
<script type="text/javascript">
function queryCustomer(){
	$("#queryform").submit();
}

</script>
</head>
<body>
	<%PageInfo<SalChance>  pageInfoList = (PageInfo<SalChance>) session.getAttribute("pageInfoList"); %>
   <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<TD class="page_title">销售机会管理</TD>
			<TD class="page_title_middle">&nbsp;</TD>
			<TD width=3><IMG height=32
				src="images/m_mpr.gif" width=3></TD>
		</tr>
	</table>
	<form
		action="sale/select_salchance"
		method="post"  id="queryform">
		<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<th>客户名称</th>
				<td><input type="text" name="chcCustName" /></td>
				<th>概要</th>
				<td><input type="text" name="chcTitle" /></td>
				<th>联系人</th>
				<td><input type="text" name="chcLinkman" size="20" /></td>
			</tr>

			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="help"><input class="common_button" type="button"
						value="帮助"></a>&nbsp;&nbsp;&nbsp;
						<a href="sale/add_salchance"><input class="common_button"
							type="button" value="新建"></a>
					 &nbsp;&nbsp; 
					 <button class="common_button" 
					onClick="queryCustomer()">查询</button>
				</td>
			</tr>
		</table>
	</form>
	<br />
	<table width="100%" cellSpacing=0 cellPadding=0>
		<tr>
			<TD width="247" class="page_title">检索结果</TD>
			<TD width="718" class="page_title_middle">&nbsp;</TD>
			<TD width=25><IMG height=32
				src="images/m_mpr.gif" width=3></TD>
		</tr>
	</table>
	<table id="data_list_table" class="data_list_table" cellSpacing=1
		cellPadding=1>
		<tr>
			<th id="firstth">编号</th>
			<th>客户名称</th>
			<th>概要</th>
			<th>联系人</th>
			<th>联系人电话</th>
			<th>操作</th>
		</tr>
		<c:forEach	items="${pageInfoList.list }" var="salCh" >
			<tr align="center">
				<td class="list_data_number">${salCh.chcId }</td>
				<td class="list_data_text">${salCh.chcCustName }</td>
				<td class="list_data_ltext">${salCh.chcTitle }</td>
				<td class="list_data_text">${salCh.chcLinkman }</td>
				<td class="list_data_text">${salCh.chcTel }</td>
				<td class="list_data_op">
				<c:choose>
					<c:when test="${roleId!=4 }">
							<a
								href="sale/dispatch/${salCh.chcId }">
								<img title="指派"
								src="images/bt_linkman.gif"
								class="op_button" />
							</a>
					
							<a
								href="sale/edit/${salCh.chcId }">
								<img title="编辑"
								src="images/bt_edit.gif"
								class="op_button" />
							</a>

							<a
								href="sale/sale_delete/${salCh.chcId }">
								<img title="删除"
								src="images/bt_del.gif"
								class="op_button" />
							</a>
					</c:when>
					<c:otherwise>		
							<img title="指派"
								src="images/bt_linkman.png"
								class="op_button" />
							<img title="编辑"
								src="images/bt_edit.png"
								class="op_button" />
							<img title="删除"
								src="images/bt_del.png"
								class="op_button" />
					</c:otherwise>
				</c:choose>
			   </td>
			</tr>
		</c:forEach>
		<tr>
			<th colspan="100" class="pager">共${pageInfoList.total }条记录 每页 ${pageInfoList.pageSize } 条 
			第${pageInfoList.pageNum }页 
			<a href="sale/list/1">首页</a>
			<c:choose>
				<c:when test="${sessionScope.pageInfoList.hasPreviousPage }">
					<a href="sale/list/${pageInfoList.prePage }">上一页</a>
				</c:when>
				<c:otherwise>
					<font color="#ABA8AB">上一页</font>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.pageInfoList.hasNextPage }">
					<a href="sale/list/${pageInfoList.nextPage }">下一页</a>
				</c:when>
				<c:otherwise>
					<font color="#ABA8AB">下一页</font>
				</c:otherwise>
			</c:choose>
				 <a href="sale/list/${sessionScope.pageInfoList.pages }">尾页</a>
			</th>
		</tr>
	</table>
</body>
</html>