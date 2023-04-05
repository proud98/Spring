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
	<h3 class="alert alert-warning">Ex2 예제</h3>
	<br>
	<button type="button" id="btn2" class="btn btn-warnong"> json 배열 데이터 출력</button>
	<div id="out2"></div>
	
	<script type="text/javascript">
		$("#btn2").click(function(){
			
			$.ajax({
				
				type:"get",
				dataType:"json",
				url:"list2",
				success:function(data){
					
					var s=""; 
					
					$.each(data,function(i,elt){
						
						var photo=elt.photo;
						var name=elt.name;

						s+="<img src='upload/"+photo+"' width='50'>";
						s+="<b>"+name+"</b>";
						
					});

					s+=$("#out2").html(s);

				}
			});
		});
	</script>
</body>
</html>