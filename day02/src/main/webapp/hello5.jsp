<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>3단출력</h2>
		<h1><%
	for(int i=1; i <=9; i++){
		out.println("강조");
	%>
<%out.println(3*i);%></h1>
	<%} %>
</body>
</html>