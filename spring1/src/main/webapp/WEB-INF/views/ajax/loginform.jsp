<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=path %>/resources/jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#loginajaxbtn").on('click',function(){
		$.ajax({
			url : '/mvc/ajax/login',
			data : {'id':$("#id").val(), 'pw':$("#pw").val()},
			type : 'post',
			dataType : 'json',
			success : function(data){ //data? 서버로 부터 받아온 값
					//data내부 : result, logintime이 묶여서 넘어옴 ex, {result:xxx, logintime:...}
				$("#loginresultdiv").html(data.result + ":" + data.logintime);
				if(data.result=='ok'){
					//현재 body 태그 끝에 추가
					$('body').append('<input type=button id="boardajaxbtn" value="게시물주세요"><br>');
					$('body').append('<div id="boardresultdiv"></div>');					
				}
				else{
					//remove
					$("#boardajaxbtn").remove();
					$("#boardresultdiv").remove();
				}
			},
			error : function(err){ //err? error내용 
				alert(err);
			}
		}); //ajax end
	}); //loginajaxbtn end
	
	$('body').on('click',"#boardajaxbtn",function(){
		//boardajaxbtn은 맨처음에 만들어진것이 아니라 동적으로 추가된 태그이므로
		//부모태그를 먼저 선언해줌 : 모르겠으면? 무조건 body라고 지정
		$.ajax({
			url : '/mvc/ajax/boardlist',
			//요청 결과로  BoardVO 객체 5개 생성해서 ArrayList로 저장 => 해당 ArrayList리턴(Controller가 할 일)
			//리턴받아서 boardresultdiv id 태그 내부 출력
			type : 'get',
			dataType : 'json',
			success : function(server){ 
				//자바스크립트 : 배열
				var list='';
				for(var i=0;i<server.length; i++){
					// /mvc/ajax/oneboard를 경로
					// id값으로? seq사용
					list += "<a href = '' id='"+server[i].seq+"'>"+ server[i].title +"</a>"+ ":" + server[i].contents+"<br>"; 
				}
				$("#boardresultdiv").html(list);
				$('body').append('<div id="oneboarddiv"></div>');
			},
			error : function(err){ //err? error내용 
				alert(err);
			}
		}); //ajax end
	}); //boardajaxbtn end
	
	//body내부에 새로생긴 a태그 이벤트 처리
	$('body').on('click',"a",function(e){
		//a태그 기본 동작 해제
		//cf) 기본 동작 해제 : 이벤트객체.preventDefault(); 
		//이때 이벤트객체 필요하므로 function에 객체받아오기 지정
		e.preventDefault();
		// /mvc/ajax/oneboard : ajax 요청
		$.ajax({
			url : '/mvc/ajax/oneboard',
			//제목 클릭시 게시물번호 파라미터 전송
			//컨트롤러 메소드 : 파라미터 번호 같은 게시물 1개 리턴
			//id가 oneboarddiv 태그에 출력
			data : {'seq': $(this).attr('id')},
			type : 'get',
			dataType : 'json',
			success : function(server){ 
				var list='';
				list += '<br><h5>'+server.title+'의 상세내용입니다.</h5>'
				list += '번호 : '+server.seq +'<br>';
				list += '제목 : '+server.title +'<br>';
				list += '내용 : '+server.contents +'<br>';
				list += '작성 시간 : '+server.time +'<br>';
				list += '조회수 : '+server.viewcount +'<br>';
				$("#oneboarddiv").html(list);
			}
		}); //ajax end
	}); //a 태그 end
	
});//ready end
</script>
</head>
<body>
<form action="/mvc/ajax/login" method=post>
아이디 <input type=text  name="id" id="id"><br>
암호 <input type=password  name="pw" id="pw"><br>
<input type="submit" value="로그인">
<input type="button" value="ajax로그인" id="loginajaxbtn">
</form>
<div id="loginresultdiv"></div>


</body>
</html>