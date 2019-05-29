<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script type="text/javascript"
	src="script/common.js">
</script>
</head>
<body>
   <table width="100%" cellSpacing=0 cellPadding=0 border="0px">
		<tr>
			<td class="page_title">销售机会管理</td>
			<td class="page_title_middle">&nbsp;</td>
			<td width=3><IMG height=32
				src="images/m_mpr.gif" width=3></td>
		</tr>
	</table>
	<form action="sale/save_salplan" method="post">
	<table class="query_form_table" cellSpacing=1 cellPadding=1>
		<tr>
			<td width=100% height=30 align=left
				background="images/m_table_top.jpg"
				colspan="6"><strong>&nbsp;制定计划</strong></td>
		</tr>
		<tr>
				<th>计划编号</th>
				<td><input readonly="readonly" name="plaId" value="${count }" /></td>
				<th>客户编号</th>
				<td><input readonly="readonly" name="plaChcId" value="${count }" size="20" /></td>
		</tr>
		<tr>
				<th>计划内容</th>
				<td><input type="text" name="plaTodo" value="" id="txt" /><span
					class="red_star">*</span></td>
				<th>结果</th>
				<td><input type="text" name="plaResult" value="" />
				<span class="red_star">*</span></td>
		</tr>
		<!-- <tr>
			<th>编号</th>
			<td></td>
			<th>机会来源</th>
			<td></td>
		</tr>
		<tr>
			<th>客户名称</th>
			<td></td>
			<th>成功机率（%）</th>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th>概要</th>
			<td colspan="3"></td>
		</tr>
		<tr>
			<th>联系人</th>
			<td></td>
			<th>联系人电话</th>
			<td></td>
		</tr>
		<tr>
			<th>机会描述</th>
			<td colspan="3"></td>
		</tr>
		<tr>
			<th>创建人</th>
			<td></td>
			<th>指派给</th>
			<td></td>
		</tr> -->
		<tr>
			<td width=100% height=32 align=center colspan=6 bgcolor=#ffffff>
				<a href="help"><input class="common_button" type="button"
					value="帮助"></a>&nbsp;&nbsp;&nbsp; 
						<input type="submit" value="执行">
						 &nbsp;&nbsp;&nbsp; 
			<!-- 			<font color="#ABA8AB">执行</font> -->
					 <a href="sale/dev/1"><input class="common_button"
					type="button" value="返回"></a>
			</td>
		</tr>
	</table>
	</form>
	<br />
</body>
</html>