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
		Cookie[] cookies = request.getCookies();
	
		String joinid = null;
		
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("joinid")){
				joinid = cookie.getValue();
				
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
		}
	%>
	<hr>
		<form action="login_db.jsp" method="post">
			아이디<input type="text" name="userid" placeholder="아이디를 입력하세요" value="<%=joinid==null?"":joinid%>">
			비밀번호<input type="password" name="userpw">
			<input type="submit" value="로그인">
		</form>
	<hr>
</body>
</html>