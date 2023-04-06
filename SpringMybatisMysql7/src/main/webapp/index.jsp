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
	<button type="button" class="btn btn-info" style="width: 200px;" onclick="location.href='samsung/list'">차량입고</button><br>
	<%-- <c:redirect url="samsung/list"></c:redirect> --%>
	<button type="button" class="btn btn-info" style="width: 200px;" onclick="location.href='member/list'">고객명단</button>
	
	<button type="button" class="btn btn-info" style="width: 200px;" onclick="location.href='sawon/list'">사원명단</button>
</body>
</html>