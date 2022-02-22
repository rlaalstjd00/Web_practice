<%@page import="com.minsung.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String userid = request.getParameter("userid");
	String userpw = request.getParameter("userpw");

	UserDAO udao = new UserDAO();

	if(udao.login(userid, userpw)){
		// 로그인 성공	
		session.setAttribute("loginUser", userid);
		response.sendRedirect("mainview.jsp");
	}else{
		
		// 로그인 실패
		response.sendRedirect("loginview.jsp?login=false");
	}
	
	
%>