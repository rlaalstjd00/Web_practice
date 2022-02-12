<%@page import="com.minsung.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	UserDAO udao = new UserDAO();
	String userid = request.getParameter("userid");
	
	// 아이디가 중복되면 "X", 중복되지 않으면 "O"
	if(udao.checkId(userid)){
		out.println("O");
	}else{
		out.println("X");
	}
%>