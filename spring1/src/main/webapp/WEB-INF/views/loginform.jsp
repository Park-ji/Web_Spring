<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- resources/jquery-3.2.1.min.js : 현재 같은 컨텍스트에 있음 -->
<!-- 현재 컨텍스트 : mvc  -->
<script src="<%=path %>/resources/jquery-3.2.1.min.js"></script><!-- 컨텍스트 바뀌어도 상관 X  -->
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
로그인 화면을 생성합니다.<br>
<!-- action : http://ip:port/mvc/WEB-INF/views/loginresult.jsp -->
<!-- 매핑 : http://ip:port/mvc/loginresult -->
<!-- Servlet, jsp : /의 의미 = 컨텍스트명까지 생략-->
<!-- html : /의 의미 = port번호까지 생략 -->
<form action="<%=path %>/login" method="post">
<!--요청 -> Dispatcher -> Controller -> 메소드 실행(Model, View 생성) -->
<!-- 아이디 입력 : <input type=text name="id1"><br> -->
아이디 입력 : <input type=text name="id"><br>
암호 입력 : <input type="password" name="pw"><br>
<input type=submit value="로그인">
</form>
</body>
</html>























