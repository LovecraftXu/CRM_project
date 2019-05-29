<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.briup.crm.common.bean.CstService"%>
<%@page import="com.github.pagehelper.PageInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>服务处理</title>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="css/test1.css"
	rel="stylesheet" type="text/css">
<script src="script/common.js"></script>
<script type="text/javascript">
function queryselect(){
	$("#queryform").submit();
}

</script>
</head>
<body>
			<table width="100%" cellSpacing=0 cellPadding=0 border="0px">
				<tr>
					<td class="page_title">客户服务管理</td>
					<td class="page_title_middle">&nbsp;</td>
					<td width=3><IMG height=32
						src="images/m_mpr.gif" width=3>
					</td>
				</tr>
			</table>
			<form action="cust_service/select_service1" name="frm" method="post" id="queryform">
				<table class="query_form_table" cellSpacing=1 cellPadding=1>
			<tr>
				<td width=100% height=30 align=left
					background="images/m_table_top.jpg"
					colspan="6"><strong>&nbsp;服务处理</strong></td>
			</tr>
			<tr>
				<th height="28">客户</th>
				<td><input type="text" name="svrCustName"/></td>
				<th height="28">概要</th>
				<td><input type="text" name="svrTitle"/></td>
			</tr>
			<tr>
				<th height="28">服务类型</th>
				<td><select name="svrType" >
						<option value="" selected='selected'>全部</option>
						<option value="咨询">咨询</option>
						<option value="建议">建议</option>
						<option value="投诉">投诉</option>
				</select></td>
				<th height="22">状态</th>
				<td><input type="text" name="svrStatus" value="已分配" /></td>
				<!-- <td><select name="svrStatus" >
						<option value="新创建" selected='selected'>新创建</option>
						<option value="已分配">已分配</option>
						<option value="已处理">已处理</option>
						<option value="已归档">已归档</option>
				</select></td> -->
			</tr>
			<tr>
				<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
					<a href="help"><input class="common_button" type="button"
						value="帮助"></a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button class="common_button" 
					onClick="queryselect()">查询</button>
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
						src="images/m_mpr.gif" width=3>
					</TD>
				</tr>
			</table>
			<table id="data_list_table" class="data_list_table" cellSpacing=1
				cellPadding=1>
				<tr>
					<th id="firstth">编号</th>
					<th>客户</th>
					<th>概要</th>
					<th>服务类型</th>
					<th>创建人</th>
					<th>操作</th>
				</tr>
					<c:forEach	items="${pageInfoList.list }" var="ser" >
						<tr align="center">
							<td class="list_data_number">${ser.svrId }</td>
							<td class="list_data_text">${ser.svrCustName }</td>
							<td class="list_data_ltext">${ser.svrTitle }</td>
							<td class="list_data_text">${ser.svrType }</td>
							<td class="list_data_text">${ser.svrCreateBy }</td>
							<td align="center">
									<a  
										href="cust_service/deal_detail/${ser.svrId}">
										<img 
										src="images/bt_deal.gif"
										class="op_button" />
									</a>
								</td>
						</tr>
					</c:forEach>
			
		<tr>
			<th colspan="100" class="pager">共${pageInfoList.total }条记录 每页 ${pageInfoList.pageSize } 条 
			第${pageInfoList.pageNum }页 
			<a href="cust_service/deal/1">首页</a>
			<c:choose>
				<c:when test="${sessionScope.pageInfoList.hasPreviousPage }">
					<a href="cust_service/deal/${pageInfoList.prePage }">上一页</a>
				</c:when>
				<c:otherwise>
					<font color="#ABA8AB">上一页</font>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${sessionScope.pageInfoList.hasNextPage }">
					<a href="cust_service/deal/${pageInfoList.nextPage }">下一页</a>
				</c:when>
				<c:otherwise>
					<font color="#ABA8AB">下一页</font>
				</c:otherwise>
			</c:choose>
				 <a href="cust_service/deal/${sessionScope.pageInfoList.pages }">尾页</a>
			</th>
		</tr>
			
</table>			
</body>
</html>