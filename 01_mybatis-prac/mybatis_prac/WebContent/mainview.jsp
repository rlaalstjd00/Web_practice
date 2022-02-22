<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mainview</title>
</head>
<body>
	<%
		String loginUser = null;
		if(session.getAttribute("loginUser")==null){
	%>
		<script>
			alert("로그인 후 이용하세요!");
			location.href = "loginview.jsp";
		</script>
	<% 
		}else{
			loginUser = (String)session.getAttribute("loginUser");
	%>
		<table>
			<tr>
				<td><%= loginUser %> 님 방문을 환영합니다! </td>
			</tr>
		</table>
	<%
		}
	%>
</body>
</html>