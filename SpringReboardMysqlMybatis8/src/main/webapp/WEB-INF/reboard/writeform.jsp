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
	<div style="margin: 30px 30px;">
		<form action="insert" method="post" enctype="multipart/form-data">
		<!-- hidden -->
		<input type="hidden" name="num" value="${num }">
		<input type="hidden" name="currentPage" value="${currentPage }">
		<input type="hidden" name="regroup" value="${regroup }">
		<input type="hidden" name="restep" value="${restep }">
		<input type="hidden" name="revel" value="${revel }">
		
		<table class="table table-bordered" style="width: 500px;">
		<caption><b>
			<c:if test="${num==0 }">새글쓰기</c:if>
			<c:if test="${num!=0 }">답글쓰기</c:if>
		</b></caption>
		
		<tr>
		<th width="100" bgcolor="#ffccc">작성자</th>
			<td>
			<input type="text" name="writer" class="form-control" required="required" style="width: 400px;">
			</td>
		</tr>
		
		<tr>
		<th width="100" bgcolor="#ffccc">비밀번호</th>
			<td>
			<input type="password" name="password" class="form-control" required="required" style="width: 400px;">
			</td>
		</tr>
		
		<tr>
		<th width="100" bgcolor="#ffccc">제목</th>
			<td>
			<input type="text" name="subject" class="form-control" required="required" style="width: 400px;">
			</td>
		</tr>
		
		<tr>
		<th width="100" bgcolor="#ffccc">사진</th>
			<td>
			<input type="file" name="upload" multiple="multiple" class="form-control" style="width: 400px;">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
			<textarea name="content" class="form-control" required="required" style="width: 500px; height: 200px;"></textarea>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-default">저장</button>
			<button type="button" class="btn btn-default" onclick="location.href='list'">목록</button>
			</td>
		</tr>
		
		</table>
		</form>
	
	</div>
</body>
</html>