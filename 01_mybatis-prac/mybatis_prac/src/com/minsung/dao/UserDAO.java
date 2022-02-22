package com.minsung.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.minsung.dto.UserDTO;
import com.minsung.mybatis.SqlMapConfig;

public class UserDAO {
	SqlSession sqlsession;
	
	public UserDAO() {
		sqlsession = SqlMapConfig.getFactory().openSession(true);
	}
	
	// 아이디 중복검사
	public boolean checkId(String userid) {
		int result = 1;
		result = sqlsession.selectOne("User.checkId",userid);
		return result == 0;
	}

	// 회원가입
	public boolean join(UserDTO newUser) {
		int result = sqlsession.insert("User.join", newUser);
		return result == 1;
	}
	
	// 로그인
	public boolean login(String userid, String userpw) {
		int result = 0;
		HashMap<String,String> datas = new HashMap<String, String>();
		
		datas.put("userid",userid);
		datas.put("userpw", userpw);
		result = sqlsession.selectOne("User.login", datas);

		return result == 1;
	}
}
