<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	String cnt_ = request.getParameter("cnt"); // request : ���尴ü
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
		�ȳ��ϼ��� <br>
	<% } %>
	// �ڵ�� �� �ڵ�� jsp�� ����� ������ {} �ʼ� 
</body>
</html>