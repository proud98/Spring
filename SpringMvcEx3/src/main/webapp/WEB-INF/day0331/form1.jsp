<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Edu+VIC+WA+NT+Beginner:wght@600&family=Gamja+Flower&family=Single+Day&family=Jua&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>

<title>Insert title here</title>
</head>
<body>
	<h2>get방식 폼</h2>
	<form action="read1" method="get"> <!-- 액션주소는 하나값만...주소의 마지막 이름만... -->
		이름: <input type="text" name="name" size="6"><br>
		나이: <input type="text" name="age" size="5"><br>
		<button type="submit">get방식 전송</button>
	</form>
	
	<hr>
	
	<h2>post방식 폼_dto로 읽기</h2>
	<form action="read2" method="post">
		상품: <input type="text" name="sang" size="10"><br>
		가격: <input type="text" name="price" size="10"><br>
		<button type="submit">post방식 전송</button>
	</form>
	
	<hr>
	
	<h2>post방식 폼_map로 읽기</h2>
	<form action="read3" method="post">
		상품: <input type="text" name="sang" size="10"><br>
		가격: <input type="text" name="price" size="10"><br>
		<button type="submit">post방식 전송</button>
	</form>
</body>
</html>