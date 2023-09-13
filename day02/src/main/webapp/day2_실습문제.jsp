<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "day_2.Book1" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1번 -->

<%-- 	<% 
	String su1_ = request.getParameter("su1");
	String su2_ = request.getParameter("su2");

	int su1 = Integer.parseInt(su1_);
	int su2 = Integer.parseInt(su2_);

	int add = su1 + su2;
	int multi = su1 * su2;
	int subtract = su1 - su2;
	int division = su1 / su2;
	%>
	<p>
	<%
	out.println("<html>");
	out.println("<head><title>계산 결과</title></head>");
	out.println("<body>");
	out.println("<h1>덧셈: " + add + "</h1>");
	out.println("<h1>곱셈: " + multi + "</h1>");
	out.println("<h1>나눗셈: " + division + "</h1>");
	out.println("<h1>뺄셈: " + subtract + "</h1>");
	out.println("</body>");
	out.println("</head>");
	%></p>  --%>
	
	<%
	Book1 book = new Book1("김", "테", 120);
	out.println(book.toString());
	%>
</body>
</html>