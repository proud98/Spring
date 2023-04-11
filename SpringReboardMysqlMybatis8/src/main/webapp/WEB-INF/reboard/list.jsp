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

	<div style="width: 800px; text-align: right; margin: 50px 50px; font-size: 2em;">
		<span class="list1 glyphicon glyphicon-th-large" style="cursor: pointer;"></span>
		<span class="list2 glyphicon glyphicon-th-list" style="cursor: pointer;"></span>
	</div>
	
	<div class="restlist" style="margin-top: 50px; margin-left: 50px;"></div>
	
	<script type="text/javascript">
		//1번째 아이콘
		$("span.list1").click(function(){
			
			//$(".restlist").html("출력1"); 클릭되는지 확인
			$("span.list1").css("color","red");
			$("span.list2").css("color","black");
			
			$.ajax({
				
				type:"get",
				dataType:"json",
				url:"list1",
				success:function(res){
					
					var tag="";
					tag+="<table class='table' style='width:800px;'>"; 
					
					$.each(res,function(i,elt){
						
						tag+="<tr height='110'><td>";
						tag+="<h3><b>"+elt.subject+"</b></h3>";
						tag+=elt.content+"<br>";
						
						if(elt.photo!='no'){
							tag+="<span style='float:right;'>";
							tag+="<img width='100' height='100' src='../photo/"+elt.photo+"'><br>";
							tag+="</span>";
						}
						
						tag+="작성자: "+elt.writer;
						tag+="</td></tr>";
					});
					
					tag+="</table>";
					$(".restlist").html(tag);
				}
			});
			
			
		});
		
		//2번째 아이콘
		$("span.list2").click(function(){
			
			//$(".restlist").html("출력1"); 클릭되는지 확인
			$("span.list1").css("color","black");
			$("span.list2").css("color","red");
			
			
		});
		
		
	</script>
	
	
	
	
	
	<!-- <div class="list"></div>
	
	<script type="text/javascript">
	function list(){
		
		$.ajax({
			
			type:"get",
			dataType:"json",
			url:"/rest/list1",
			success:function(res){
				
				var s="";
				
				$.each(res,function(i,elt){
					
					s+="<table>";
					s+="<tr><td>"+${elt.writer};
					s+=${elt.subject};
					s+=${elt.writeday};
					s+="</td></tr>";
					s+="</table>"
					
				});
				$("div.list").html(s);
			}
		});
	}
	
	$("span.list1").click(function(){
		
		list();
	});
	
	</script> -->
</body>
</html>