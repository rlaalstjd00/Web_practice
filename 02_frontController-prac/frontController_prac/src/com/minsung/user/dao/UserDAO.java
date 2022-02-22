package com.minsung.user.dao;

import org.apache.ibatis.session.SqlSession;

import com.minsung.user.dao.UserDTO;
import com.minsung.mybatis.SqlMapConfig;

public class UserDAO {
	SqlSession sqlsession;
	
	public UserDAO() {
		sqlsession = SqlMapConfig.getFactory().openSession(true); 
	}
	
	public boolean join(UserDTO newUser) {
		int result = sqlsession.insert("User.join", newUser);
		return result == 1;
	}
}
