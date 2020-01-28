<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=path%>/resources/jquery-3.2.1.min.js"></script>
<script>
	var websocket; //전역변수 처리
	$(document).ready(function() {

		//1. 웹소켓 생성 : 웹 소켓 url 사용
		$("#enterbtn").on('click', function() {
			//현재 컨텍스트/chatws
			websocket = new WebSocket("ws://localhost:8081/mvc/chatws"); 

			//선생님 컴퓨터에 접속?
			//http프로토콜 후에 웹소켓 진행되므로 선생님이 localhost가 아닌 선생님 ip로 들어가야함
			//선생님도 ws안의 url를 192.168.15.200:8082/mvc/로 바꿔놔야함
			//즉, url에 192.168.15.200:8082/mvc/chat?id=xxx 로 접근
			
			//아래 3가지 메소드는 웹 소켓 생성이 된 후에 실행이 되어야함(밖에 있으면 일종의 NullpointException발생)
			//3. 서버가 응답결과 전송받음
			//서버가 응답결과 전송받았을 때 자동 처리 내용
			websocket.onmessage = function(server) {
				var nick = $("#nickname").val();
				var info = server.data.split(":");
				//console.log(info[0]);
				if(info[0]==nick){
					$("#chatmessagearea").append($("<div class='my'>"+server.data + "</div><br>"));
/* 			 			 .css("background-color","yellow")
 						 .css("text-align","right") */
/* 						  .css("float","right")
						 .css("line-height","200%"));   */
					//css는 jquery문법이니까 jquery 객체로 만듦
				}
				else{
					$("#chatmessagearea").append(server.data + "<br>");
				}			
			}			
			//cf) 서버와 연결되었을 때 자동 처리 내용
			websocket.onopen = function() {
				console.log("웹소켓 연결 성공");
			}
			//cf) 서버와 해제되었을 때 자동 처리 내용
			websocket.onclose = function() {
				console.log("웹소켓 연결 해제 성공");
			}
	
		}); //enterbtn end

		//2. 서버로 데이터 보냄 : 현재 클라이언트가 서버로 ('닉네임':'문자') 데이터 보냄
		$("#sendbtn").on('click', function() {
			//nickname:message 정보 읽기
			var nick = $("#nickname").val();//input태그 값 읽기
			var msg = $("#message").val();
			websocket.send(nick + ":" + msg);
		}); //sendbtn end



		//4. 웹 소켓 서버 연결 해제
		$("#exitbtn").on('click', function() {
			websocket.close();
		}); //exitbtn en
	}); //ready end
</script>
<style>
.my{
background-color:yellow; 
float:right;
} 
</style>
</head>
<body>
	아이디 :
	<input type=text  id="nickname" value="${param.id }">
	<input type=button id="enterbtn" value="채팅방입장">
	<input type=button id="exitbtn" value="채팅방퇴장">

	<h1>채팅방</h1>
	<div id="chatarea">
		<div id="chatmessagearea"></div>
		<!-- <div id="mychatmessagearea"></div> -->
	</div>

	전송할 메세지 :
	<input type="text" id="message">
	<input type=button id="sendbtn" value="메시지전송">
</body>
</html>