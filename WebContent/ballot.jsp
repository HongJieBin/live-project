<%//@page import="maskAppointment.pojo.proof"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="maskAppointment.dao.BallotRecordDAO"%>
<%@page import="maskAppointment.dao.BallotRecordDAOImpl,maskAppointment.pojo.BallotRecord,java.util.*"%>
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
    <div>最新一轮中签名单</div>
    <div>
    	<table border="1">
    	<tr>
    		<td>中签记录id</td>
    		<td>市民身份证</td>
    		<td>中签轮数</td>
    	</tr>
    	<%
            List<BallotRecord> ballotRecords = (List<BallotRecord>)request.getAttribute("ballotRecords");
            for(BallotRecord ballotRecord:ballotRecords){
            %>
            <tr>
            	<td><%=ballotRecord.getRecordId()%></td>
    			<td><%=ballotRecord.getIdNumber()%></td>
				<td><%=ballotRecord.getBallotRound()%></td>
			</tr>
			<%
            }
            %>
   </table>
	</div>
</body>
</html>
