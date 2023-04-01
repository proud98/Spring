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
	
	<!--총점과 평균 구하기  -->
	<c:set var="tot" value="${Spring+Java }"/>
	<c:set var="avg" value="${tot/2 }"/>
 
	<h1>result2.jsp 입니다</h1>
	<h2>HelloController 로부터 포워드됨</h2>
	<b>자바점수: ${Java } </b><br>
	<b>스프링점수: ${Spring } </b><br> <!--requestScope.은 생략가능  -->
	<b>합계: ${tot } </b><br>
	<b>평균: ${avg } </b>
	
</body>
</html>