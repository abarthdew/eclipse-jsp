<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String cnt_ = request.getParameter("cnt"); // request : 내장객체
	int cnt = 100;
	if (cnt_ != null && !cnt_.equals("")) {
		cnt = Integer.parseInt(cnt_);
	}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<% for (int i=0; i<cnt; i++) { %>
		안녕하세요 <br>
	<% } %>
	// 코드블럭 내 코드는 jsp가 만들기 때문에 {} 필수 
</body>
</html>