<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/category.css" rel="stylesheet" />
<script>
	function check() {
		return true;
	}
</script>
</head>
<body>
	<div class="jy_total">
		<div class="jy_header">
			<img
				src="https://i.namu.wiki/i/C-_u2aimbGxZ6ZYaoyI1nCywa-L0zMloWRKWx4br-daAGYi1V72GUpqyTi5Uvcu84Fks3-O3avP3noY9dMP-LQ.webp" />
		</div>
		<div class="jy_wrap">
			<div class="jy_body">
				<form name="frm" action="VIP.jsp
  " method="post"
					onsubmit="return check()">
					<button id="btn1">유저 조회</button>
				</form>

				<form name="frm" action="서버.jsp
  " method="post"
					onsubmit="return check()">
					<button id="btn2">상품관리</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>