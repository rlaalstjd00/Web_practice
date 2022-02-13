package com.minsung.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsung.user.UserJoinOkAction;
import com.minsung.action.ActionForward;


public class UserFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		doProcess(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//길 나누는 코드
		String requestURI = req.getRequestURI();	// re_board_mvc2/user/UserJoin.us
		String contextPath = req.getContextPath();	// re_board_mvc2
		// 받아온 URI에서 contextPath부분을 잘라서 나머지 부분과 switch문으로 분기
		// 이렇게 하면 모듈의 이름을 바꾸거나 잘못 설정하지 않는다고 해도 어차피 잘려나가기 때문에 문제가 발생하지 않음
		String command = requestURI.substring(contextPath.length()); // /user/UserJoin.us
		ActionForward forward = null;
		
		switch(command) {
			case "/user/UserJoinOk.us":
				try {
					forward = new UserJoinOkAction().execute(req, resp);
				} catch (Exception e) {
					System.out.println("UserJoinOk : " + e);
				}
				break;
			case "/user/UserLogin.us":
				forward = new ActionForward();
				forward.setPath("/loginview.jsp");
				forward.setRedirect(false);
				break;
		}
		
		if(forward != null) {
			if(forward.isRedirect()) {
				resp.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher disp = req.getRequestDispatcher(forward.getPath());
				disp.forward(req, resp);
			}
		}
	}
}
