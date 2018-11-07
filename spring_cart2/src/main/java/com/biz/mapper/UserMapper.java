package com.biz.mapper;

import org.springframework.stereotype.Repository;

import com.biz.vo.UserVO;

@Repository(value="userDAO")
public interface UserMapper {
	public UserVO getUser(UserVO vo);
}
