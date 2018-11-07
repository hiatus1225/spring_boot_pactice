<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta name="google-signin-client_id" content="132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com"> -->
<title>Insert title here</title>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>

<script>
$( document ).ready(function() {
	$( "#loginBtn" ).click(function() {
		if(this.value == 'login') { 
			googleAuth.signIn({
					scope:'https://www.googleapis.com/auth/calendar'
				}).then(function(){ 
					console.log('login done');
					checkLoginStatus();
				});
		} else {
			googleAuth.signOut().then(function(){ 
				console.log('logout done');
				checkLoginStatus();
			});
		}
	});
});	
</script>
<script>
function checkLoginStatus() {
	var loginBtn = document.querySelector("#loginBtn");
	var nameTxt = document.querySelector("#namespan");
	
	if(googleAuth.isSignedIn.get()) {
		console.log("logined")
		loginBtn.value = "logout";
		var googleUser = googleAuth.currentUser.get().getBasicProfile();
		console.log(googleUser.getName());
		nameTxt.innerHTML = "<b>"+googleUser.getName()+"</b>";
	}else {
		console.log("login out")
		loginBtn.value = "login";
		nameTxt.innerHTML = "";
	}
}
function init() {
		gapi.load('auth2', function() { 
			console.log("dd");
			window.googleAuth = gapi.auth2.init({
				client_id:'132153140522-9kncrdhhuao0ik7fk37i3r1en8c30qle.apps.googleusercontent.com'
			});
			googleAuth.then(
				function(){
					console.log("googleAuth oninit")
					checkLoginStatus();
				},
				function(){
					console.log("googleAuth onerror")
				}
			); //then
		}); //load
}
/* function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
} */
</script>
</head>
<body>
	<span id="namespan"></span>
	<input type="button" id="loginBtn" value="login..">

	<!-- 
<div class="g-signin2" data-onsuccess="onSignIn"></div>
 -->
	<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>


</body>
</html>