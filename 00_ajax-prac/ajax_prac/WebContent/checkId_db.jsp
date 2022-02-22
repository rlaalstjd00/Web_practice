<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "***";
	String password = "***";
	Connection conn = DriverManager.getConnection(url, user, password);
	
	String userid = request.getParameter("userid");
	
	String sql = "SELECT * FROM AJAX_TEST_USER WHERE USERID = ?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, userid);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()){
		out.println("X");
	}else{
		out.println("O");
	}
%>
