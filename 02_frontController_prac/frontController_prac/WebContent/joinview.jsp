<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<c:set var="cp" value="${pageContext.request.contextPath}"/>
	<h2>회원가입</h2>
	<form name="joinform" method="post" action="${cp}/user/UserJoinOk.us">
		아이디 <input type="text" placeholder="아이디" name="userid"><br>
		비밀번호 <input type="password" placeholder="비밀번호" name="userpw"><br>
		이름 <input type="text" placeholder="이름" name="username"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>