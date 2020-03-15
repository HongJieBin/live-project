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
	<form action="OrderServlet" method="get">
		<div class="oneline">
			<div class="input">真实姓名：</div>
			<input type="text" name="name">
		</div>
		<div class="oneline">
			<div class="input">身份证号码：</div>
			<input type="text" name="idNumber"/>
		</div>
		<div class="oneline">
			<div class="input">手机号码：</div>
			<input type="text"/>
		</div>>
		<div class="oneline">
			<div class="input">预约口罩数量：</div>
			<input type="text" name="orderMask">
		</div>
		<input type="submit" value="提交">
		<% 
			String orderNum=request.getSession().getAttribute("OrderNumber");
			if(orderNum==null)
				out.pirnt("<script>alter('预约失败!');</script>");
			else 
				out.print("<script>alter('预约成功！你的预约号码是："+orderNum+"')</script>");
			request.removeAttribute("OrderNumber");
		%>>		
	</form>
</center>
</div>
</body>
</html>