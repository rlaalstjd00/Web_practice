<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "web";
	String password = "web";
	Connection conn = DriverManager.getConnection(url, user, password);

	String sql = "INSERT INTO AJAX_TEST_USER VALUES(?,?,?)";
	PreparedStatement ps = conn.prepareStatement(sql);
	String userid = request.getParameter("userid");
	ps.setString(1,userid);
	ps.setString(2,request.getParameter("userpw"));
	ps.setString(3,request.getParameter("username"));

	int result = ps.executeUpdate();
	
	if(result == 1){
		// 성공 
		response.addCookie(new Cookie("joinid",userid));
		response.sendRedirect("login.jsp");
	}else{
		// 실패
		response.sendRedirect("join_fail.jsp");
	}

%>