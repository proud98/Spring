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
	<button type="button" style="width: 100px;" class="btn btn-info" onclick="location.href='writeform'">멤버추가</button>

	<c:if test="${totalCount==0 }">
		<h3>등록 된 회원이 없습니다</h3>
	</c:if>
	
	<c:if test="${totalCount>0 }">
		<h3>총 ${totalCount }개의 글이 있습니다</h3>
		
		<table class="table table-bordered" style="width: 700px;">
			<tr bgcolor="#fffcc">
			<th width="50">번호</th>
			<th width="80">이름</th>
			<th width="80">연락처</th>
			<th width="80">주소</th>
			<th width="80">가입일</th>
			<th width="80">수정/삭제</th>
			</tr>
			
			<c:forEach var="dto" items="${mlist }" varStatus="i">
				<tr>
					<td>${i.count }</td>
					<td>${dto.name }</td>
					<td>${dto.hp }</td>
					<td>${dto.addr }</td>
					<td>${dto.gaipday }</td>
					<td>
					<button type="button" class="btn btn-default btn-xs" onclick="location.href='updateform?num=${dto.num}'">수정</button>
					<button type="button" class="btn btn-default btn-xs" onclick="location.href='delete?num=${dto.num}'">삭제</button>
					</td>
				</tr>
			</c:forEach>
		
		</table>

	</c:if>
</body>
</html>