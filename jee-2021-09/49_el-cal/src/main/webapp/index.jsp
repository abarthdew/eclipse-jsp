<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	${param.num > 3 } <br>
	${param.num ge 3 } // html에서 > 문자가 오류가 날 수 있기 때문에 <br>
	${empty param.num } // 키워드는 전달됐지만 값을 가지고 있지 않을 때(null, "") <br>
		ㄴ http://localhost:8080/el-cal | (null) <br>
		ㄴ http://localhost:8080/el-cal?num= | ("") <br>
	${param.num == null || param.num == ''} // 위와 결과가 같음 <br>
	${param.num/2 } // 정수/정수=정수여야 하는데 결과는 소수점이 나옴 => jstl에서 해결 <br>
		ㄴ http://localhost:8080/el-cal?num=3
</body>
</html>
<!--  http://localhost:8080/el-cal?num=5 -->
