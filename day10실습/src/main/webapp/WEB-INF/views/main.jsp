<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	/*function nameSet(){
		 alert("시작");
		 var inputValue = document.getElementById("idInput").value;
		 alert(inputValue);
		 
		//console.log(inputValue);
		//${login = inputValue}
		//${login = inputValue}
	}*/
</script>
<body>
	 
	 
	<%
	   String  l = (String)  session.getAttribute("login");
	out.println( l ); 
	%>
	login1  ${login}
	login12 ${sessionScope.login}
	<c:choose>
		<c:when test="${empty  sessionScope.login}">
			<form action="/day10실습/main" method="get">
				<table>
					<tr>
						<td><input type="text" id="idInput" name="idname"></td>
					</tr>
					<tr>
						<td><button onclick="nameSet()" type="submit" >로그인</button></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:when test="${not empty login}">
			<form action="/day10실습/main" method="get">
				<table>
					<tr>
						<td><input type="text" id="idInput" name="idname"></td>
					</tr>
					<tr>
						<td><button onclick="nameSet()" type="submit" >로그아웃</button></td>
					</tr>
				</table>
			</form>
		</c:when>
	</c:choose>

</body>

</html>