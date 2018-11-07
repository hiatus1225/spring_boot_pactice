<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html >
<head>
<body>
<table border="1" cellpadding="0" cellspacing="0">
<thead>
	<tr>
		<th>BSEQ</th>
		<th>TITLE</th>
		<th>USERID</th>
		<th>REGDATE</th>
		<th>REPLYLIST</th>
	</tr>
</thead>
<tbody>

<c:forEach items="${LVL_BRLIST}" var="sss">
	<tr>
		<td>${sss.bseq}</td> 
		<td>
			<%-- <a href="/view?bseq=${sss.bseq}">  --%>
			<a href="/view/${sss.bseq}"> 
			<font color="black">${sss.title}</font></a>
		</td>
		<td>${sss.userid}</td>
		<td>${sss.regdate}</td>
		<!--  댓글 목록 보여주기 -->
		<td>
			<c:forEach items="${sss.boardReplyVOList}" var="r">
				${r.rseq} ${r.reply}<br>
			</c:forEach>
		</td>
	</tr>
	
</c:forEach>
<%// } %>
</tbody>
</table>

<a href="/board/form.jsp">글쓰기</a>
</body>
</html>
