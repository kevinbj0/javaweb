<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="coffee.Coffee"%>
<%@ page import="coffee.CoffeeDao"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table>
		<tr>
			<td>코드</td>
			<td>이름</td>
			<td>가격</td>
		</tr>
		<%ArrayList<Coffee> list = (ArrayList<Coffee>)request.getAttribute("list");
	for(Coffee c : list){
	%>
		<tr>
			<td><%=c.getCode() %></td>
			<td><%=c.getName() %></td>
			<td><%=c.getPrice() %></td>
		</tr>
		<%} %>
	</table>

	<%
	 
 
	int currentPage = (Integer)request.getAttribute("curPage");	
	int totRecords = (Integer)request.getAttribute("totCnt");
	int pageSize = 2; //페이지 사이즈
	int totalPage; 
	int grpSize = 8; //그룹 사이즈
	int currentGrp = 0; //현재 그룹
	
	//총 페이지수 구하기
	int remain = totRecords % pageSize;
	if(remain == 0){
		totalPage = totRecords / pageSize;
	}else{
		totalPage = totRecords / pageSize +1;
	}
	
	//현재 그룹 구하기
	int remain2 = currentPage % grpSize;
	
	if(remain2 == 0){
		currentGrp = currentPage/grpSize;
	}else{
		currentGrp = currentPage/grpSize+1;
	}
	//시작 페이지 끝페이지
	int grpStartPage = (currentGrp-1)*grpSize+1;
	int grpEndPage = currentGrp*grpSize;
	
	if(grpEndPage>totalPage){
		grpEndPage = totalPage;
	}
	
	//이전버튼 다음버튼
	int index = grpStartPage;
	if(currentGrp >1){ %>
	<a href="/day11_실습/list.page?p=<%=index-1%>">[이전]</a>
	<% }
	while(index <= grpEndPage){
	%>
	<a href="/day11_실습/list.page?p=<%=index%>">[<%=index%>]</a>
	<% 
	index ++;
	}
	if(grpEndPage < totalPage){
	%>
	<a href="/day11_실습/list.page?p=<%=index%>">[다음]</a>
	<% 
	}
	%>

</body>
</html>