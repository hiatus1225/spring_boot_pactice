<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.js?ver=4"></script>
<script>
$(document).ready(function(){
/* 	function detect(URL) {
	    var image = new Image();
	    image.src = URL;
	    var x = image.onload = function() {
	        var result = [{ x: 45, y: 56 }]; // An example result
	        return result;
	    }();
	    return x;
	} */
	
	
});

function detect(URL) {
	$("#di").empty();
    var image = new Image();
    image.src = URL;
    $("#di").append(image);
    
}
</script>
<body>
<h1> kim 님 Cart상세</h1>
<div id="di">
</div>
<table>

<c:forEach items="${cartVO.goodsList}" var="gvo">
<tr>
	<td>${gvo.gname} ${gvo.gprice}<br></td>
		<c:forEach items="${gvo.goodsImgVOs}" var="ivo">
			<td>${ivo.imgPath} ${ivo.imgName}<br>
			<%-- <a href="http://localhost/cdir/${ivo.imgName}"> --%>
			<a href="#"  onclick="detect('${ivo.imgName}')">
			<img src="/cdir/${ivo.imgName}"></a>
			</td>
		</c:forEach>
</tr>
	</c:forEach>
	



</table>


</body>
</html>
