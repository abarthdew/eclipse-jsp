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
	${param.num ge 3 } // html���� > ���ڰ� ������ �� �� �ֱ� ������ <br>
	${empty param.num } // Ű����� ���޵����� ���� ������ ���� ���� ��(null, "") <br>
		�� http://localhost:8080/el-cal | (null) <br>
		�� http://localhost:8080/el-cal?num= | ("") <br>
	${param.num == null || param.num == ''} // ���� ����� ���� <br>
	${param.num/2 } // ����/����=�������� �ϴµ� ����� �Ҽ����� ���� => jstl���� �ذ� <br>
		�� http://localhost:8080/el-cal?num=3
</body>
</html>
<!--  http://localhost:8080/el-cal?num=5 -->
