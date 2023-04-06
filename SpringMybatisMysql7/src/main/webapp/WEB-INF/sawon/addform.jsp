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
	<form action="insert" method="post" enctype="multipart/form-data">
		<table class="table table-bordered" style="width:400px; ">
		<caption>사원 데이터 입력</caption>
			<tr>
			<th bgcolor="#fffcc">사원명</th>
				<td>
				<input type="text" name="name" class="form-control" style="width: 300px;" required="required">
				</td>
			</tr>
			
			<tr>
			<th bgcolor="#fffcc">부서명</th>
				<td>
				<input type="text" name="buseo" class="form-control" style="width: 300px;" required="required">
				</td>
			</tr>
			
			<tr>
			<th bgcolor="#fffcc">사진</th>
				<td>
				<input type="file" name="upload" class="form-control" style="width: 300px;">
				</td>
			</tr>
			
			<tr>
			<th bgcolor="#fffcc">운전면허</th>
				<td>
				<input type="radio" name="driver" value="있음">있음
				<input type="radio" name="driver" value="없음">없음
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<button type="submit" class="btn btn-warning">저장</button>
				<button type="button" class="btn btn-warning" onclick="location.href='list'">목록</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>