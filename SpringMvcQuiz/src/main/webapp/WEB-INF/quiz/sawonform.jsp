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
	<h1>사원폼~~</h1>
	<form action="sawonresult" method="post">
		사원명: <input type="text" name="name" size="10"><br>
		부서명: <input type="text" name="buseo" size="10"><br>
		급여: <input type="text" name="pay" size="10"><br>
		나이: <input type="text" name="age" size="10"><br>
		혈액형: <input type="text" name="blood" size="10"><br>
		
		<button type="submit">전송</button>
	</form>
</body>
</html>