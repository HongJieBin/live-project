<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>管理员界面</title>
<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
</head>
<body>
	<div id="button">
		<a href=""><button>返回</button></a>
    </div>
    <div id="button">
        <a href="ballot.jsp"><button>导出中签名单</button></a>
    </div>
    <br/>
    <div>
    	<div>设置预约时间段</div>
    	<div>
    		<form>
    			开始时间：
    			<input class="Wdate" name="beginTime" type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})"><br/>
    			结束时间：
    			<input class="Wdate" name="endTime" type="text" onClick="WdatePicker({el:this,dateFmt:'yyyy-MM-dd HH:mm:ss'})">
    		</form>
    	</div>
    </div>
    <br/>
    <div>
    	<div>设置口罩数量</div>
    	<div>
    		<form>
    			单人单次最高可预约数：
    			<select name="singleNum">
    				<%
    				int i;
    				for(i = 1;i <= 100;i++){
    				%>
    				<option><%=i %></option>
    				<%} %>
    			</select><br/>
    			本轮预约口罩总数：
    			<select name="totalNum">
    				<%
    				int j;
    				for(j = 1;j <= 1000;j++){
    				%>
    				<option><%=j %></option>
    				<%} %>
    			</select><br/>
    		</form>
    	</div>
    </div>
    <br/>
    <div id="button">
		<a href=""><button>提交</button></a>
    </div>
</body>
</html>
