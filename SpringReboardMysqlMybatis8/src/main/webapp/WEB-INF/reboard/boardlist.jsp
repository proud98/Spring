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
		<table class="table table-bordered" style="width: 800px;">
		<caption><b>Spring 게시판</b>
			<span style="float: right;">
			<button type="button" class="btn btn-default" onclick="location.href='writeform'">글쓰기</button>
			</span>
		</caption>
			
			<tr bgcolor="#fffcc" align="center">
				<td width="50"><b>번호</b></td>
				<td width="340"><b>제목</b></td>
				<td width="60"><b>작성자</b></td>
				<td width="100"><b>작성일</b></td>
				<td width="40"><b>조회</b></td>
			</tr>
			
			<c:if test="${totalCount==0 }">
				<tr>
				<td colspan="5" align="center"><b>등록 된 글이 없습니다</b> </td>
				</tr>
			</c:if>
			
			<c:if test="${totalCount>0 }">
				<c:forEach var="dto" items="${list }">
					<tr>
						<td align="center">${no }</td>
						<c:set var="no" value="${no-1 }"/><!--출력 후 감소(증감식(--)이 적용 안되어서 대체)  -->
						
						<!-- 제목 -->
						<td>
						<!-- relrvel만큼 공백 -->
						<c:forEach begin="1" end="${dto.relevel }">
							&nbsp;&nbsp; <!--2칸 띄우기(원글이 0이면 안띄워짐)  -->
						</c:forEach>
						
						<!--답글이면 re이미지 출력  -->
						<c:if test="${dto.relevel>0 }"><!-- restep으로 써도 됨 -->
							<img alt="" src="../photo/re.png">
						</c:if>
						
						
						<!-- 제목 (내용보기로 이동) -->
						<a href="content?num=${dto.num }&currentPage=${currentPage }">${dto.subject }</a>
						
						<c:if test="${dto.acount>0 }">
							<a href="content?num=${dto.num }&currentPage=${currentPage }#answer" style="color: red;">[${dto.acount}]</a>
						</c:if>
						
						<!-- 이미지 있을 경우 아이콘 표시 -->
						<c:if test="${dto.photo!='no' }">
							<img alt="" src="../photo/photoimg.png" style="width: 15px;">
						</c:if>
						</td>
						
						<td>${dto.writer }</td>
						<td> <fmt:formatDate value="${dto.writeday }" pattern="yyyy.MM.dd HH:mm"/> </td>
						<td>${dto.readcount }</td>
					</tr>
				</c:forEach>
			</c:if>
		
		</table>
		
		<c:if test="${totalCount>0 }">
			<div style="width: 800px; text-align: center;" class="container">
				<ul class="pagination"> 
				
					<!-- 이전 -->
					<c:if test="${startPage>1 }">
					<li>
					<a href="list?currentPage=${startPage-1 }">이전</a>
					</li>
					</c:if>
					
					<c:forEach var="pp" begin="${startPage }" end="${endPage }">
						<c:if test="${pp==currentPage }">
						<li class="active">
						<a href="list?currentPage=${pp }">${pp }</a>
						</li>
						</c:if>
						
						<c:if test="${currentPage!=pp }">
						<li>
						<a href="list?currentPage=${pp }">${pp }</a>
						</li>
						</c:if>
					</c:forEach>
					
					<!-- 다음  -->
					<c:if test="${endPage<totalPage }">
					<li>
					<a href="list?currentPage=${endPage+1 }">다음</a>
					</li>
					</c:if>
				
				</ul>
			
			</div>
		
		</c:if>
	
	</div>
</body>
</html>