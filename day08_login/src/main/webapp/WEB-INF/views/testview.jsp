<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>테스트뷰</h2>
	<%
		String data = (String)request.getAttribute("test");
		out.println(data);
	%>
</body>
</html>