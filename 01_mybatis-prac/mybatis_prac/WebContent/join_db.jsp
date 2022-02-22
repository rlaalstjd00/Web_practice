<%@page import="com.minsung.dao.UserDAO"%>
<%@page import="com.minsung.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="newUser" class="com.minsung.dto.UserDTO"/>
<jsp:setProperty property="*" name="newUser"/>

<%
	UserDAO udao = new UserDAO();
	
	if(udao.join(newUser)){
		// 회원가입 성공
		response.sendRedirect("loginview.jsp?joinid="+newUser.getUserid());
	}else{
		// 회원가입 실패
		response.sendRedirect("joinview.jsp?join=false");
	}

%>
