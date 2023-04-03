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
	<%-- <c:set var="tot" value="${dto.su*dto.dan }"></c:set> --%>
	
	<h2>상품정보 출력</h2>
	<div style="color: ${dto.color};">
		상품명: ${dto.sang }
		수량: <fmt:formatNumber value="${dto.su }" pattern=""/>
		단가: <fmt:formatNumber value="${dto.dan }" type="currency"/>
		총액: <fmt:formatNumber value="${dto.su*dto.dan }" type="currency"/>
	</div>
</body>
</html>