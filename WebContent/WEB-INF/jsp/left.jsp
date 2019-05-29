<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="utf-8">
<title>客户关系管理系统</title>

<link rel="stylesheet" type="text/css" href="css/nav.css">
<link rel="stylesheet" type="text/css" href="css/iconfont.css">

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/nav.js"></script>

<script type="text/javascript">
	//点击跳转
	function forward(url) {
		parent.frames["mainFrame"].location.href = url;
	}
</script>
</head>
<body>
	<div class="nav">
		<div class="nav-top">
			<div id="mini"
				style="border-bottom: 1px solid rgba(255, 255, 255, .1)">
				<img src="images/mini.png">
			</div>
		</div>
		<ul>
		<c:if test="${roleId!=1 }">
			<!--只有主管 高管 客户经理有营销管理-->
			<li class="nav-item"><a href="javascript:;"><i
					class="my-icon nav-icon  icon-iconset0253"></i><span>营销管理</span><i
					class="my-icon nav-more"></i></a>
				<ul>
				<c:if test="${roleId==2 ||roleId==3 }">
					<!--只有主管和高管才有销售机会管理   -->
					
					<li onclick="forward('sale/list/1')"><a
					target="mainFrame"><span>销售机会管理</span></a></li>
				</c:if>
				<c:if test="${roleId==2 ||roleId==4 }">
					<!--只有经理和高管才有客户开发计划  -->
					<li onclick="forward('sale/dev/1')"><a
					target="mainFrame"><span>客户开发计划</span></a></li>
				</c:if>
				</ul>	
			</li>
		
		</c:if>
			
			

			<!-- 都有 -->
			<li class="nav-item"><a href="javascript:;"><i
					class="my-icon nav-icon icon-touxiang"></i><span>客户管理</span><i
					class="my-icon nav-more"></i></a>
				<ul>
					<li onclick="forward('cust_info/list/1')"><a
						target="mainFrame"><span>客户信息管理</span></a></li>
				</ul>
			</li>
		
		<c:if test="${roleId!=1 }">
			<!--只有高管 主管 经理有  -->
			<li class="nav-item"><a href="javascript:;"><i
					class="my-icon nav-icon icon-worldwide"></i><span>服务管理</span><i
					class="my-icon nav-more"></i></a>
				<ul>
					<li onclick=""><a href="cust_service/add"
						target="mainFrame"><span>服务创建</span></a></li>
					<li onclick="forward('cust_service/dispatch/1')"><a
						target="mainFrame"><span>服务分配</span></a></li>	
					<li onclick="forward('cust_service/deal/1')"><a
						target="mainFrame"><span>服务处理</span></a></li>	
					<li onclick="forward('cust_service/feedback/1')"><a
						target="mainFrame"><span>服务反馈</span></a></li>	
				</ul>
			</li>
		</c:if>
		
		<c:if test="${roleId!=4 }">
			<!--只有管理员 高管 主管有  -->
			<li class="nav-item"><a href="javascript:;"><i
					class="my-icon nav-icon icon-alarm"></i><span>统计报表</span><i
					class="my-icon nav-more"></i></a>
				<ul>
					<li onclick=""><a href="jfreechart/contr"
		
						target="mainFrame"><span>客户贡献分析</span></a></li>
					<li onclick=""><a href="jfreechart/cons?condit=0"
						target="mainFrame"><span>客户构成分析</span></a></li>
				</ul></li>
		</c:if>

		
			<!-- 都有 -->
			<li class="nav-item"><a href="javascript:;"><i
					class="my-icon nav-icon icon-shengyuliuliang"></i><span>基础数据</span><i
					class="my-icon nav-more"></i></a>
				<ul>
					<li onclick="forward('basic/product/1')"><a
					target="mainFrame"><span>查询产品信息</span></a></li>
					<li onclick="forward('basic/storage/1')"><a
					target="mainFrame"><span>查询库存</span></a></li>
				</ul></li>
		<c:if test="${roleId<3 }">
			<!--只有系统管理员和高管有  -->
			<li class="nav-item"><a href="javascript:;"><i
					class="my-icon nav-icon icon-chilun"></i><span>系统设置</span><i
					class="my-icon nav-more"></i></a>
				<ul>
					<li onclick=""><a href="systemset/role_manage"
						target="mainFrame"><span>角色管理</span></a></li>
					<li onclick=""><a href="systemset/user_manage"
						target="mainFrame"><span>用户管理</span></a></li>
					<li onclick=""><a href="systemset/log_review"
						target="mainFrame"><span>日志查看</span></a></li>
				</ul></li>
		</c:if>
		</ul>
	</div>
</body>
</html>