<%--@ page import="com.kosmo.board.daovo.BoardVO"--%>
<%--@ page import="java.util.ArrayList"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Board</title>
<h5><font size="14" color="purple">Board List!!!!</font></h5>
<style>
      #boardcount{font-size:10px;}
      #rem{font-size:1rem;}
</style>
</head>

<body>

<table class="blueTable" >
<thead>
	<tr>
		<th>BSEQ</th>
		<th>TITLE</th>
		<th>USERID</th>
		<th>REGDATE</th>
		<th><a href="/boardInsert">글쓰기</a></th>
	</tr>
</thead>
<tbody>
	
	<c:forEach items="${list}" var="lists">
	<tr>
		<td>${lists.bseq}</td>
		<td><a href="/view/${lists.bseq}">${lists.title}</a></td>
		<td>${lists.userid}</td>
		<td>${lists.regdate}</td>
	</tr>

 
	</c:forEach>
	<%-- <tr>
		<td><%=list.get(i).getBseq()%></td>
		<td><a href="/boardview?bseq=<%=list.get(i).getBseq()%>"><%=list.get(i).getTitle()%></a></td>
		<td><%=list.get(i).getUserid()%></td>
		<td><%=list.get(i).getRegdate()%></td>
	</tr>
<% } %> --%>
</tbody>
</table>


</body>
</html>