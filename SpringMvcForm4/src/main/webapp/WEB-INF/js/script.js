/**
 * 
 */
$(function(){
	
	//초기이미지
	$("#myimg").attr("src","../image/최고심2.jpg")
	
	//이벤트
	$("#myimg").hover(function(){
		
		$(this).attr("src","../image/최고심.jpg");
	},function(){
		$(this).attr("src","../image/최고심2.jpg");
	});
	
});