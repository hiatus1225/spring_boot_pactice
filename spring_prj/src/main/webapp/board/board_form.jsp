<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InsertBoard</title>
<style></style>
<!-- <link rel="stylesheet" href="board/css/my.css?ver=421431"> -->
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
</head>
<body>
<h1>Board Form</h1>
<hr>
<form id="myForm" name="myForm" method="post" action="/boardWrite" enctype="multipart/form-data">
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
				<th>첨부파일</th>
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