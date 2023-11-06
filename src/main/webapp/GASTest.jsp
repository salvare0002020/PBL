<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GASテスト</title>
</head>
<body>
	<form action="/PBL/GASTestServlet" accept-charset="UTF-8" method="post">
		<input type="text" name="title"><br>
		<input type="date" name="startDate"><br>
		<input type="date" name="endDate"><br>
		<input type="number" name="money"><br>
		<input type="text" name="memo"><br>
		<input type="submit">
	</form>
</body>
</html>
