<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="my.css">
<title>查询预约界面</title>
</head>
<body>
<div class="main">
<center>
	<form action="queryRes.jsp" method="get">
	<div class="oneline"><div class="input">预约编号：</div><input type="text" name="ballotRecord"></div>
	<input type="submit" value="查询">	
	</form>
</center>
</div>
</body>
</html>