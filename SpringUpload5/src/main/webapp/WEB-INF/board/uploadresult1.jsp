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
	<h2>제목: ${title }</h2>
	
	<!-- 실제 업로드 된 이미지 가져오기 -->
	<c:if test="${fileName=='no' }">
		<b>업로드 한 파일 없음</b>
	</c:if>
	
	<c:if test="${fileName!='no' }">
		<img alt="" src="../photo/${fileName }">
	</c:if>
	
	<h2>업로드 한 이미지명: ${fileName }</h2>
	<h2>업로드 할 실제 경로: ${path }</h2>
</body>
</html>