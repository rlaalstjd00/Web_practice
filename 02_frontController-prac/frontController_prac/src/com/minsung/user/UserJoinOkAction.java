package com.minsung.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsung.action.Action;
import com.minsung.action.ActionForward;
import com.minsung.user.dao.UserDAO;
import com.minsung.user.dao.UserDTO;

public class UserJoinOkAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		UserDTO udto = new UserDTO();
		UserDAO udao = new UserDAO();
		
		udto.setUserid(req.getParameter("userid"));
		udto.setUserpw(req.getParameter("userpw"));
		udto.setUsername(req.getParameter("username"));
		
		ActionForward forward = null;
		
		if(udao.join(udto)) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath(req.getContextPath()+"/user/UserLogin.us?userid="+req.getParameter("userid"));
		}
		return forward;
	}
}
