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
	<form action="write" method="post">
		<table class="table table-bordered" style="width: 350px;">
		<caption>멤버 정보 입력</caption>
			<tr>
			<th bgcolor="pink" width="100">이름</th>
				<td>
				<input type="text" name="name" required="required">
				</td>
			</tr>
			
			<tr>
			<th bgcolor="pink" width="100">연락처</th>
				<td>
				<input type="text" name="hp" required="required">
				</td>
			</tr>
			
			<tr>
			<th bgcolor="pink" width="100">주소</th>
				<td>
				<input type="text" name="addr" required="required">
				</td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center">
				<button type="submit" class="btn btn-default">가입</button>
				<button type="button" class="btn btn-default" onclick="location.href='memberlist'">목록</button>
				</td>
			</tr>
			
		</table>
	
	</form>
</body>
</html>