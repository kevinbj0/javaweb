<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.ArrayList" %>
<%@ page import ="acorn.Customer" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<h2>에이콘 학생리스트</h2>


<% //ArrayList<Customer> list  =(ArrayList<Customer>) request.getAttribute("list"); %>


<%/* for( int i=0; i< list.size() ;i++){	
	out.println( list.get(i).getId()  );
	out.println( list.get(i).getPw() );
	out.println( list.get(i).getName() +"<br>");
}*/%>

<!-- 요소 하나하나를 꺼내서 item에 저장하겠다. -->
<!-- item 하나가 customer 하나 -->
<c:forEach var="item" items="${list}"> 
	${item.id}
	${item.pw}
	${item.name}
</c:forEach>
 

</body>
</html>