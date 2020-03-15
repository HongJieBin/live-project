<%//@page import="maskAppointment.pojo.proof"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>中签名单</title>
</head>
<body>
	<div id="button">
		<a href="admin.jsp"><button>返回</button></a>
    </div>
    <%//OrderInformation information = new OrderInformation();%>
    <div>第<%//=information.getOrderRound() %>轮中签名单</div>
    <div>
    	<table border="1">
    	<tr>
    		<td>真实姓名</td>
    		<td>手机尾号</td>
    		<td>预约口罩数量</td>
    	</tr>
    	<%
    		//Proof proof = new Proof();
            //List<Order> orders = (List)request.getAttribute("orderId");    
            //for(Order order:orders)
            //{%>
        <tr>
        	<td><%//=order.getName()%></td>
        	<td><%//=order.getPhone()%></td>
        	<td><%//=order.getOrderNum()%></td>
        	<%//} %>
        </tr>
   </table>
	</div>
</body>
</html>
