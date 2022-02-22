<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 성공!</title>
</head>
<body>
	<%
		String check = request.getParameter("login");
		if(check != null){
	%>
		<script>
			alert("로그인 실패! 다시 시도해주세요")
		</script>
	<% 		
		}
		String joinid = request.getParameter("joinid");
	%>
	<hr>
		<form name = "loginForm" action="login_db.jsp" method="post" onsubmit="return sendit()">
			아이디<input type="text" name="userid" 
				placeholder="아이디를 입력하세요" value="<%=joinid==null?"":joinid%>">
			비밀번호<input type="password" name="userpw" placeholder="비밀번호를 입력하세요">
			<input type="submit" value="로그인">
		</form>
	<hr>
</body>
<script>
	let idTag = document.loginForm.userid;
	let pwTag = document.loginForm.userpw;
	
	function sendit(){
		if(idTag.value == ""){
			alert("아이디를 입력하세요!");
			idTag.focus();
			return false;
		}
		if(pwTag.value == ""){
			alert("비밀번호를 입력하세요!");
			pwTag.focus();
			return false;
		}
		return true;
	}
</script>
</html>