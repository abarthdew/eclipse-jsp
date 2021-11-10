<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String num_ = request.getParameter("num");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	int num = 0;
	if (num_ != null && !num_.equals("")) {
		num = Integer.parseInt(num_);
	}
	// 코드 블럭은 나누어져 있어도 순서만 맞으면 됨 -> 나누어져 있는 블럭을 찾기 어려움 -> 스파게티 코드
%>
<body>
	<% if (num%2 != 0) { %>
		홀수입니다.
	<%} else { %>
		짝수입니다.
	<%} %>
</body>
</html>

<!--  http://localhost:8080/index.jsp?num=3 -->