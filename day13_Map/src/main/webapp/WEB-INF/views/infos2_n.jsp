<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 값 가져오기 -->
<c:set var="list" value = "${infos['fruit']}"/>
<!-- 출력 -->
<c:forEach var = "item" items = "S{list}">
	${item}
</c:forEach>

<c:set var = "list2" value = "${infos['veverage']}"/>
<c:forEach var = "item" items = "${list2}">
	${item}
</c:forEach>

</body>
</html>