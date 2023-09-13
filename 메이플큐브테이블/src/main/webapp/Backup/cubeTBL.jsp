<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/list.css" rel="stylesheet" />
</head>
<body>
<table>
<tr>
<td>Item코드</td>
<td>이름</td>
<td>확률</td>
<td>가격</td>
</tr>
<%
	Connection con=null;
	Statement st = null;
	ResultSet rs = null;
	try{ 
		String driver = "oracle.jdbc.driver.OracleDriver" ;
		
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 여기 확인 : testdb, 패스워드
		String url="jdbc:oracle:thin:@localhost:1521:testdb";
		String user="scott";
		String password="tiger";
		//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
		 //1. 오라클드라이버 로딩
		Class.forName(driver); 
		//2. 데이터베이스 연결
		con= DriverManager.getConnection(url, user, password); 
		
		//3. statement 얻어오기
		st = con.createStatement();
		
		 //4. 필요한 sql 작성
		//String sql ="select * from member_tbl_11"; 
		String sql ="select * from item_cubetbl";
		rs = st.executeQuery(sql) ;
		while( rs.next() ) {
%>
<tr>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getString(4)%></td>
</tr>
<%
		}
		}catch(Exception e){
		e.printStackTrace();
	}
	finally{ //자원의 반납
		if( st != null) st.close();
		if( con != null) con.close();
	}
%>
</table>
</body>
</html>