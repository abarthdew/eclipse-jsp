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
	// �ڵ� ���� �������� �־ ������ ������ �� -> �������� �ִ� ���� ã�� ����� -> ���İ�Ƽ �ڵ�
%>
<body>
	<% if (num%2 != 0) { %>
		Ȧ���Դϴ�.
	<%} else { %>
		¦���Դϴ�.
	<%} %>
</body>
</html>

<!--  http://localhost:8080/index.jsp?num=3 -->