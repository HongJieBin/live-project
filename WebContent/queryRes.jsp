<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String currentBallot=(String)$_POST["ballotRecord"];
	boolean isShot=false;
	List<Proof> proofs =(List)request.getAttribute("proofs");
	for(Proof proof:proofs){
		if(proof.getOrderId().equals(currentBallot)){
			isShot=true;
			out.println("购买凭证");
			out.println("市民姓名："+proof.getName());
			out.println("身份证号码："+getIdNumber());
			out.println("手机号码："+getPhone());
			out.println("预约口罩数量："+getOrderNum());
		}		
	}
	if(isShot==false)
		System.out.println("很遗憾，您未中签！");		
	%>	
	<jsp:forward page="query.jsp"></jsp:forward>
</body>
</html>