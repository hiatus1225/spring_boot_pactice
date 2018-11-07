package com.biz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.UserMapper;
import com.biz.service.UserService;
import com.biz.vo.UserVO;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userDAO;
//	public void setUserDAOSETTER(UserDAO u100) {
//		this.userDAO = u100;
//	}
//	 
//	public UserServiceImpl(UserDAO u100) {
//		this.userDAO = u100;
//	}
	public UserVO getUser(UserVO vo){
		//--------------------DI ------------------------
		//UserDAO userDAO = new UserDAO();	
		//--------------------DI ------------------------
		vo = userDAO.getUser(vo);
		System.out.println(vo.getName());
		return vo; 
	}
}
