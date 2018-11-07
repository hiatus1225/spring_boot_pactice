<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="6cvv4nbdb8gi5soug53972g2vaa9hgn.apps.googleusercontent.com">
<script>
function mySignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	}
</script> 


<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
$(document).ready();
function butn() {	

	$("#googleLoginButton").click(function(){
		//alert(googleAuth.isSignedIn.get());
	
		//var googleAuth = gapi.auth2.getAuthInstance();
		
		//if(googleAuth.isSignedIn.get() == true) {
		if(this.value == "login") {
			//구글 로그인 처리
			googleAuth.signIn(
					//{scope: 'profile email'}		
			).then( function(){
						//버튼글자 logout으로 변경
						$("#googleLoginButton").val("logout");
						
						//로그인 유저정보 꺼내서 resdiv에 보이기
						var googleUser = googleAuth.currentUser.get();
						console.log('ID(googleUser): ' + googleUser.getId()); // Do not send to your backend! Use an ID token instead.
						console.log('HostDomain(googleUser): ' + googleUser.getHostedDomain()); 
						console.log('Scope(googleUser): ' + googleUser.getGrantedScopes());
						
						var profile = googleUser.getBasicProfile();
						console.log('ID(profile): ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
						console.log('Name: ' + profile.getName());
						console.log('Image URL: ' + profile.getImageUrl());
						console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
						
						
						var authResponse  = googleUser.getAuthResponse();
						console.log('access_token: ' + authResponse.access_token);
						console.log('id_token: ' + authResponse.id_token);
						console.log('scope: ' + authResponse.scope);
						console.log('expires_in: ' + authResponse.expires_in);
						console.log('expires_at: ' + authResponse.expires_at);
						console.log('first_issued_at: ' + authResponse.first_issued_at);
						
						/* //ajax통신 -> controller통해 DB에 유저 정보 저장
						url:/authRequest
						data:code
						
						
						@RequesetMapping("/authRequest")
						void send() {
							*client_id
							*securitykey
							code = getParameter("code")
							//https://accounts.google.com/o/oauth2/v2/auth.
							post.send(url, prms);
						}
						@RequestMapping("/google_redirect") 
						json : access_token */
						
						
						$("#googleDiv").empty();
						var htmlStr = "<img src='"+profile.getImageUrl()+"'>";
						htmlStr += profile.getName() + "님 환영합니다.";
						$("#googleDiv").html(htmlStr);	
						
						listUpcomingEvents();
						
			        }
			);
		} else if(this.value == "logout") {
		//} else if(googleAuth.isSignedIn.get() == false) {	
			//구글 로그아웃 처리
			googleAuth.signOut(
					//{scope: 'profile email'}		
			).then( function(){
						//버튼글자 login으로 변경
						$("#googleLoginButton").val("login");
						$("#googleDiv").empty();
						$("#googleDiv").html("");	
			        }
			);
			
			/* 
			//scope 관련 연결된 메일, 달력 접속 다 끊기
			googleAuth.disconnect();
			
			//scope 관련 연결된 메일, 달력 중 부분 접속 다 끊기
			googleAuth.grantOfflineAccess(
					{scope: 'profile email'}		
			).then( function(res){
						console.log(res.code);
					} 
			); 
			*/
		}
	});
	
    function appendPre(message) {
        var textContent = document.createTextNode(message + '\n');
        $("#googleDiv").html(textContent);
      }

    
	 function listUpcomingEvents() {
	        gapi.client.calendar.events.list({
	          'calendarId': 'primary',
	          'timeMin': (new Date()).toISOString(),
	          'showDeleted': false,
	          'singleEvents': true,
	          'maxResults': 10,
	          'orderBy': 'startTime'
	        }).then(function(response) {
	          var events = response.result.items;
	          $("#googleDiv").html('Upcoming events:');

	          if (events.length > 0) {
	            for (i = 0; i < events.length; i++) {
	              var event = events[i];
	              var when = event.start.dateTime;
	              if (!when) {
	                when = event.start.date;
	              }
	              appendPre(event.summary + ' (' + when + ')')
	            }
	          } else {
	            appendPre('No upcoming events found.');
	          }
	        });
	      }

</script>

</head>
<body>
구글 인증 테스트<hr>
<!-- 
<div class="g-signin2" data-onsuccess="mySignIn"></div> 
-->
<div id="googleDiv"></div>
<input type="button" id="googleLoginButton" value="login">

<hr>
<form action="/login" method="post">
아이디 : <input type="text" name="id" value="admin"><br>
비번 : <input type="text" name="pw" value="111"><br>
<input type="submit" value="Controller 로그인" >
</form>

<script>
function myOnLoad() {
	var CLIENT_ID = '478571279368-k78fvmdai327j2g9nr0agii41ioipola.apps.googleusercontent.com';
    var API_KEY = 'AIzaSyCFSJpGF2Pjj9Znb8lW-XADdBJNMQbQvQY';
    var DISCOVERY_DOCS = ["https://www.googleapis.com/discovery/v1/apis/calendar/v3/rest"];
    var SCOPES = "https://www.googleapis.com/auth/calendar.readonly";
	//gapi.auth2.GoogleAuth
	gapi.load('client:auth2', googleAuth);
			
		//googleAuth.then(ok, fail);
		
}

function googleAuth (){
	 gapi.client.init({
	//client_id: '478571279368-k78fvmdai327j2g9nr0agii41ioipola.apps.googleusercontent.com'
	//,	scope , 'https://www.googleapis.com/auth/calendar'
      apiKey: API_KEY,
      clientId: CLIENT_ID,
      discoveryDocs: DISCOVERY_DOCS,
      scope: SCOPES
	 
}).then(butn)
}
/* 
function ok() {
	console.log("gapi.load 성공")
}

function fail() {
	console.log("gapi.load 실패")
} */
</script>

<script src="https://apis.google.com/js/platform.js?onload=myOnLoad" async defer></script>




</body>
</html>