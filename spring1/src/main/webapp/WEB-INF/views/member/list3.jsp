<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="jquery-3.2.1.min.js"></script>
<script>
$(document).ready(function(){

});
</script>
</head>
<body>
<!--  
ID검색/이름 검색 선택 : 'va' 입력 / '김'입력 : 검색요청 버튼 클릭하면
컨트롤러 메소드 정의 추가 : public ? searchlist(?) {
id에 va를 포함하고 있는 회원 리스트만 출력 뷰
name에 김을 포함하고 있는 회원 리스트만 출력 뷰
}
-->

<form action="/mvc/member/searchlist"><!-- get,post 방식 둘다 가능  -->
<select name="searchitem"><!-- 선택한 종류  -->
<c:forEach items="${searchmodel }" var="searchcondition">
<option>${searchcondition }</option>
</c:forEach>
</select>
<input type="text" name="searchword"><!-- 검색한 단어  -->
<input type="submit" value="검색요청">
</form>

<h1>검색 가능한 회원 정보를 출력합니다.</h1>
<c:forEach items="${listmodel }" var="member">
${member.id } 회원님 : ${member.name } <br>
</c:forEach>
</body>
</html>