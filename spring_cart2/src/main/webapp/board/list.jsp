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
	</tr>
</thead>
<tbody>

<c:forEach items="${LVL_LIST}" var="sss">
	<tr>
		<td>${sss.bseq}</td> 
		<td>
			<%-- <a href="/view?bseq=${sss.bseq}">  --%>
			<a href="/view/${sss.bseq}"> 
			<font color="black">${sss.title}</font></a>
			<c:if test="${sss.ufileSize > 0}">
				<a href="/down/${sss.ufileName}">
					${sss.ufileName}
				</a>	
				 ( ${sss.ufileSize} bytes )
				
			</c:if>
		</td>
		<td>${sss.userid}</td>
		<td>${sss.regdate}</td>
	</tr>
	
</c:forEach>
<%// } %>
</tbody>
</table>

<a href="/board/form.jsp">글쓰기</a>
</body>
</html>
