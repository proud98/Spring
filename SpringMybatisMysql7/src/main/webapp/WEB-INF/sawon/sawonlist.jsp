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
	<span class="alert alert-warning">
		<b>총 ${totalCount }개의 사원명단이 있습니다</b>
	</span><br><br>
	
	<button type="button" class="btn btn-warning" onclick="location.href='form'">명단추가</button><br><br>
	<hr>
	
	<div style="width: 800px; text-align: center;">
		<form action="list" class="form-inline">
		
			<select name="title" class="form-control" style="width: 100px;">
				<option value="name" ${title=='name'?"selected":"" }>이름</option>
				<option value="buseo" ${title=='buseo'?"selected":"" }>부서</option>
				<option value="driver" ${title=='driver'?"selected":"" }>운전면허</option>
			</select>
			
			<input type="text" name="search" value="${search }" class="form-control" placeholder="검색단어" style="width: 200px;">
			
			<button type="submit" class="btn btn-warning">검색</button>
			
		</form>
	</div>	
	
	<table class="table table-bordered" style="width:700px; ">
		<caption>사원 명단
		
		<c:if test="${searchCount>0 && searchCount!=totalCount  }">
			<div style="font-size: 12pt; display: flex;">
			 <b>'${search }'</b>의 검색결과 &nbsp;<b>${searchCount}</b>개를 찾았습니다
			 </div>
		</c:if>
		
		<c:if test="${searchCount==0}">
			<div style="font-size: 12pt; display: flex;">
			 <b>'${search }'</b>의 검색결과가 없습니다
			 </div>
		</c:if>
		
		</caption>
			<tr bgcolor="#fffcc">
				<th>No</th>
				<th>사진</th>
				<th>사원명</th>
				<th>부서명</th>
				<th>운전면허</th>
				<th>가입일</th>
				<th>수정/삭제</th>
			</tr>
	
	
			<c:forEach var="dto" items="${list }" varStatus="i">
			<tr>
				<td>${i.count }</td>
				<td>
					<c:if test="${dto.photo!='no' }">
						<img alt="" src="../photo/${dto.photo }" width="80">
					</c:if>
					
					<c:if test="${dto.photo=='no' }">
						<b>이미지 없음</b>
					</c:if>
				</td>
				<td>${dto.name }</td>
				<td>${dto.buseo }</td>
				<td>${dto.driver }</td>
				<td>${dto.ipsaday }</td>
				
				<td>
				<button type="button" class="btn btn-default btn-xs" onclick="location.href='updateform?num=${dto.num}'">수정</button>
				<button type="button" class="btn btn-default btn-xs" onclick="location.href='delete?num=${dto.num}'">삭제</button>
				</td>
			</tr>
			</c:forEach>
			
		</table>
		
</body>
</html>