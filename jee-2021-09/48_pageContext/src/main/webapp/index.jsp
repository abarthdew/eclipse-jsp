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
	// 페이지 객체 : 페이지 내에서 저장소로 쓸 수 있는 객체
	// 페이지 객체에 담는 내용을 el을 통해 쓸 수 있음
%>
<%
	pageContext.setAttribute("result", "hi");
%>
<body>
	${aa }<br>
	${result } // 자바 단의 result와 이 페이지 상단의 코드블럭 result 변수이름이 동일하기 때문에, page객체가 우선<br>
	${requestScope.result } // 한정사를 붙임으로서 request 객체를 찾음 <br>
<!--  http://localhost:8080/pageContext -->
	<hr>
	// 4대 저장소 이외 저장소 <br>
	${param.num} // 자바단에 전달하는 num 변수 <br>
	${header.accept } // 사용자가 request할때 보내는 헤더 정보 <br>
<!--  http://localhost:8080/pageContext?num=5 -->
</body>
</html>
