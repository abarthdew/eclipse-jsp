<!DOCTYPE html>
<%
int x = 3;
int y = 4;
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add.jsp" method="get">
		<div>
			<ul>
				<li><label for="x">x : </label><input name="x"></li>
				<li><label for="y">y : </label><input name="y"></li>
			</ul>
			<div><input type="submit" value="sum"></div>
		</div>
	</form>
</body>
</html>


