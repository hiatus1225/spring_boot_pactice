<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="478571279368-k78fvmdai327j2g9nr0agii41ioipola.apps.googleusercontent.com">

<title>Insert title here</title>
</head>
<script>
$(document).ready(function(){
	/* &&("#button").click(function(){
		
	}); */
	
});

function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.

		$("#getid").val(profile.getId())
		$("#getname").val(profile.getName())
		$("#getemail").val(profile.getEmail())
		$("#getimg").attr("src",profile.getImageUrl())
}
	
function signOut() {
    var auth2 = gapi.auth2.getAuthInstance();
    auth2.signOut().then(function () {
      console.log('User signed out.');
    });
}
  
</script>
<body>
구글 로그인
<hr>
<div class="g-signin2" data-onsuccess="onSignIn"></div>
<br>
--미구현--
<form action="/login" method="post">
아이디 : <input type="text" name="id"><br>
비번 : <input type="text" name="pw"><br>
<input type="submit" name="전송">
</form>

<hr>
<br>
구글 정보
<br>
<hr>
<input type="text" id ="getid">
<input type="text" id ="getname">
<input type="text" id ="getemail">
<img id="getimg" src="">
</body>
</html>