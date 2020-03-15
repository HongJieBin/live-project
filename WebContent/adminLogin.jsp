<%@ page  pageEncoding="UTF-8"%>
<% %>
<!DOCTYPE html>

<html lang="en" xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>管理员登录页</title>
	<link rel="stylesheet" type="text/css" href="css/adminLogin.css" />
	<link rel="stylesheet" type="text/css" href="css/order.css" />
</head>
<body>
<button id="returnBack">&lt; 返回</button>
	<div id="header">管理员登录</div>
	<div id="wrap">	
		<div id="loadInput">
			<form action="loginServlet" method="post">
				用户名:<input class="inputSize" type="text" name="name">
				<br />
				<br />
				密码:<input class="inputSize" id="password" type="password" name="password">
				<br /><br />
				<button class="loadButton">确认</button>
			</form> 
		
	

<%
	String message = (String)request.getAttribute("message");
    if(message!=null && !"".equals(message)){
%>
			<div style="color:red">
				<%=message %>
			</div>
		</div>
	</div> 

<%
    }	
    request.setAttribute("message", "");
%>
</body>
</html>