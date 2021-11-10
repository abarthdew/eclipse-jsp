<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String num_ = request.getParameter("num");
	int num = 0;
	if (num_ != null && !num_.equals("")) {
		num = Integer.parseInt(num_);
	}
	String result = num%2 == 0 ? "짝수" : "홀수";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%= result %> 입니다<br>
	// result = 변수
</body>
</html>

<!--  http://localhost:8080/index.jsp?num=3 -->