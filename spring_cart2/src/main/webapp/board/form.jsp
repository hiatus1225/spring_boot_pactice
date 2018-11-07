<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style></style>
<link rel="stylesheet" href="/css/my.css">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

</head>
<body>
	
<h1>Board Form</h1>
<hr>
<form id="myForm" name="myForm" 
method="post" action="/write" enctype="multipart/form-data" >
  
<!-- 

	<input type="hidden" name="info" value="write">
	-->
	<table class="blueTable">
		<tbody>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" id="title" name="title">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="contents" cols="30" rows="5"></textarea>
				</td>
			</tr>
			<tr>
				<th>*첨부파일</th>
				<td><input type="file" id="ufile" name="ufile"></td>
			</tr>
			<tr>
				<th colspan="2" align="center">
				<input type="submit" id="writeBtn" value="글쓰기">
				<input type="reset" value="reset"></th>
			</tr>
		</tbody>
	</table>
</form>

</body>
</html>