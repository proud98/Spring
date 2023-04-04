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
	<div style="margin-left: 200px; margin-top: 50px;">
		
		<button type="button" class="btn btn-warning" onclick="location.href='shop/form1'">각각읽기</button>
		<button type="button" class="btn btn-warning" onclick="location.href='shop/form2'">dto읽기</button>
		<button type="button" class="btn btn-warning" onclick="location.href='shop/form3'">map읽기</button>
		
		<button type="button" class="btn btn-warning" onclick="location.href='board/uploadform1'">이미지 업로드</button>
		<button type="button" class="btn btn-warning" onclick="location.href='board/uploadform2'">이미지 여러개 업로드</button>
		
	</div>
</body>
</html>