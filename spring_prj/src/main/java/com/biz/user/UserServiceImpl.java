package com.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
//	public UserServiceImpl(UserDAO u100) {
//		this.userDAO = u100;
//	}
//	
	public UserVO getUser(UserVO vo){
		//--------------------DI ------------------------
		//UserDAO userDAO = new UserDAO();	
		//--------------------DI ------------------------
		vo=userDAO.getUser(vo);
		System.out.println(vo.getName());
		return vo; 
	}
}
