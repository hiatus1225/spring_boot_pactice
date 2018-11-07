<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="6cvv4nbdb8gi5soug53972g2vaa9hgn.apps.googleusercontent.com">
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
</script>

</head>
<body>
Send Eail<hr>
<form action="/login" method="post">
Eail Address : <input type="text" name="address" >
<br>
<textarea id="contents" name="contents" rows="30" ></textarea>
<input type="submit" value="Controller 로그인" >
</form>






</body>
</html>