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

<style type="text/css">
#answer{
border-bottom: 1px solid #add;
margin-bottom: 20px;
padding-top: 10px;
padding-bottom: 10px;
padding-left: 20px;

}
</style>
</head>
<body>

	<div style="margin: 50px 50px;">
		<table class="table table-bordered" style="width: 600px;">
		<caption><b>내용보기</b></caption>
			<tr>
				<td><h4>${dto.subject }</h4>
				<span style="float: right; margin-left: 20px;">
				${dto.readcount }&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:formatDate value="${dto.writeday }" pattern="yyyy.MM.dd HH:mm"/>
				</span>
				
				<h5>${dto.writer }</h5>
				</td>	
			</tr>
			
			<tr>
				<td>
				<pre style="background-color: white; border: 0px;">${dto.content }</pre>
				
				<c:if test="${dto.photo!='no' }">
					<c:forTokens var="ps" items="${dto.photo }" delims=","> <!-- delims=""에는 구분기호 -->
						<a href="../photo/${ps }">
						<img src="../photo/${ps }" style="width: 150px;">
						</a>
					</c:forTokens>
				</c:if>
				
				</td>
			</tr>
			
			<!-- 댓글자리 -->
			<tr>
				<td>
				<div id="answer">
					<b>댓글 ${acount }</b><br>
					<c:forEach var="a" items="${alist }">
						${a.nickname }: ${a.content }
						&nbsp;&nbsp;
						<span style="color: gray; font-size: 0.8em;">
						<fmt:formatDate value="${a.writeday }" pattern="yyyy.MM.dd HH:mm"/>
						</span>
						&nbsp;&nbsp;
						<span class="glyphicon glyphicon-erase" style="cursor: pointer; width: 6px;"></span>&nbsp;&nbsp;
						<span class="delete glyphicon glyphicon-trash" style="cursor: pointer; width: 6px;" idx="${a.idx }"></span><br>
					</c:forEach>
				</div>
				
				<form action="ainsert" method="post" class="form-inline">
				<input type="hidden" name="num" value="${dto.num }">
				<input type="hidden" name="currentPage" value="${currentPage }">
					
					<b>닉네임</b>
					<input type="text" name="nickname" class="form-control input-sm" style="width: 100px;" required="required">
					<br>
					<b style="margin-left: 30px;">비밀번호</b>
					<input type="password" name="pass" class="form-control input-sm" style="width: 100px;" required="required">
					<br>
					<input type="text" name="content" class="form-control input-sm" style="width: 500px;" required="required" placeholder="댓글을 입력해주세요">
					<button type="submit" class="btn btn-default btn-sm">확인</button>
				</form>
				</td>
			</tr>
			
			<tr>
				<td align="right">
				<button class="btn btn-default" onclick="location.href='writeform'">글쓰기</button>
				<button class="btn btn-default" onclick="location.href='writeform?num=${dto.num}&regroup=${dto.regroup }&restep=${dto.restep }&relevel=${dto.relevel }&currentPage=${currentPage }'">답글쓰기</button>
				<button class="btn btn-default" onclick="location.href='updatepassform?num=${dto.num}&currentPage=${currentPage }'">수정</button>
				<button class="btn btn-default" onclick="location.href='deletepassform?num=${dto.num}&currentPage=${currentPage }'">삭제</button>
				<button class="btn btn-default" onclick="location.href='list?currentPage=${currentPage}'">목록</button>
				
				</td>
			</tr>
		
		</table>
	
	</div>
	
	<script type="text/javascript">
	
	$(document).on("click", "span.delete", function(){
		
		var idx=$(this).attr("idx");
		
		//비번 입력 할 prompt창
		var pass=prompt("비밀번호를 입력해주세요");

		//비번 확인 안하고 취소 누르면
		if(pass==null){
			return; //종료
		}
		
		
		$.ajax({
			
			type:"get",
			dataType:"json",
			url:"deleteanswer",
			data:{"idx":idx,"pass":pass},
			success:function(res){
				//AnswerRestController에서 지정한 check값 받아오기
				if(res.check==0){
					alert("비밀번호가 맞지 않아요");
				}else{
					//메세지 띄운 후 새로고침
					alert("삭제 완료");
					location.reload();
				}
			}
		})

	})
	
	</script>
</body>
</html>