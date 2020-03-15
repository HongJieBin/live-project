<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="my.css">
<title>登记预约界面</title>
</head>
<body>
	<div class="main">
		<center>
			<form action="citizenAppointServlet" method="post">
				<div class="oneline"><div class="input">真实姓名：</div><input type="text" name="name"></div>
				<div class="oneline"><div class="input">身份证号码：</div><input type="text" name="idNumber"/>
				<div class="oneline"><div class="input">手机号码：</div><input type="text" name="phone"/>
				<div class="oneline"><div class="input">预约口罩数量：</div><input type="number" name="orderNum">
				<button type="submit">预约</button>		
			</form>
		</center>
		<%
			String message = (String)request.getAttribute("message");
		%>
		<p></p>
	</div>
</body>
</html>