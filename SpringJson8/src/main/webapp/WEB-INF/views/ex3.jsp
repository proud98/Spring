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
	
	<h3 class="alert alert-danger">Ex3 예제</h3>
	<br>
	<input type="text" name="name2" id="name2" onkeyup="enterkey()">
	<div id="out3"></div>
	
	<script type="text/javascript">
		function enterkey() {
			if (window.event.keyCode == 13) {		
			    
				var name2=$("#name2").val();
				
				$.ajax({
					
					type:"get",
					dataType:"json",
					url:"list2",
					success:function(data){
						
						var s="";
						var n=0;
						
						$.each(data,function(i,elt){
							
							var photo=elt.photo;
							var name=elt.name;
							
							if(name2==name){
								s+="<img src='upload/"+photo+"' width='50'>";
								s+="<b>"+name+"</b>";
							} else {
								n+=1;
							}
									
						});
						
						if(n==data.length){
							s="다시입력하세요"
						} $("#out3").html(s);
						
					}
				});
		 
			}	
		}
	</script>
	
</body>
</html>