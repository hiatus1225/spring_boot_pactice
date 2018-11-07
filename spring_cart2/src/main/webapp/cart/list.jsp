<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
$(document).ready(function(){
	/* &&("#button").click(function(){
		
	}); */
	
});
</script>
<body>
<h1> kim 님 Cart리스트</h1>

<table>
<c:forEach items="${cartlist}" var="cvo">
<tr>

	<td><a href="/cart/${cvo.cseq}"> ${cvo.cseq}</a> </td>
	<c:forEach items="${cvo.goodsList}" var="gvo">
		<td>${gvo.gname}<fmt:formatNumber value="${gvo.gprice}" pattern="###,###,###,###,###"/><br></td>
		<%-- <c:forEach items="${gvo.goodsImgVOs}" var="ivo">
			${ivo.imgPath} ${ivo.imgName}
		</c:forEach> --%>
	</c:forEach>
	
</tr>
</c:forEach>
</table>
</body>
</html>