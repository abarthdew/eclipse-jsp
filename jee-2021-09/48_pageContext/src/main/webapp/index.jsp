<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<%
	pageContext.setAttribute("aa", "hello");
	// ������ ��ü : ������ ������ ����ҷ� �� �� �ִ� ��ü
	// ������ ��ü�� ��� ������ el�� ���� �� �� ����
%>
<%
	pageContext.setAttribute("result", "hi");
%>
<body>
	${aa }<br>
	${result } // �ڹ� ���� result�� �� ������ ����� �ڵ�� result �����̸��� �����ϱ� ������, page��ü�� �켱<br>
	${requestScope.result } // �����縦 �������μ� request ��ü�� ã�� <br>
<!--  http://localhost:8080/pageContext -->
	<hr>
	// 4�� ����� �̿� ����� <br>
	${param.num} // �ڹٴܿ� �����ϴ� num ���� <br>
	${header.accept } // ����ڰ� request�Ҷ� ������ ��� ���� <br>
<!--  http://localhost:8080/pageContext?num=5 -->
</body>
</html>
