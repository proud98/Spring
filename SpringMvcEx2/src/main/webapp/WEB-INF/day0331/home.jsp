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
	<h3>${msg }</h3>
	<h3><fmt:formatDate value="${today }" pattern="yyyy-MM-dd HH:mm"/> </h3>
	<h2>매핑 주소 연습</h2>
	<ul>
		<li><a href="apple/list">apple/list</a></li>
		<li><a href="apple/list.do">apple/list.do</a></li> <!-- 확장자 충돌을 막기위해 .do 확장자명 사용~ 요샌 안 씀  -->
		<li><a href="apple/list.nhn">apple/list.nhn</a></li>
		<li><a href="banana/insert">banana/insert</a></li>
		<li><a href="orange/delete">orange/delete</a></li>
	</ul>
	
	<h2>이미지 출력 연습</h2>
	<ul>
		<li><a href="shop/detail">resource의 이미지출력</a></li>
		<li><a href="board/add/data">퀴즈: 이미지출력</a></li> 
		<!-- 
		이 경로를 클릭하면 result5로 이동하고 
		result5에는 result4와 똑같이 이미지들 출력하기
		리소스 폴도의 이미지 출력
		web-inf/image폴더 안의 이미지 출력
		 -->
	</ul>
</body>
</html>