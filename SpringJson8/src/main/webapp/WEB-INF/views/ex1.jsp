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
	<h3 class="alert alrt-info">Ex1 예제</h3>
	<br>
	<button type="button" id="btn1" class="btn btn-info">list json 데이터 출력</button>
	<div id="out1"></div>
	
	<script type="text/javascript">
		$("#btn1").click(function(){
			
			$.ajax({
				
				type:"get",
				dataType:"json",
				url:"list1", //내가 설정한 매핑주소 주기
				success:function(res){
					
					$("#out1").empty();
					$("#out1").append("이름: "+res.name );
					$("#out1").append("연락처: "+res.hp );
					$("#out1").append("주소: "+res.addr );
					}
			
			})
		});
	</script>
</body>
</html>