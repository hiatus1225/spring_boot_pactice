package com.biz.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.mapper.CartMapper;
import com.biz.service.CartService;
import com.biz.vo.CartVO;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public ArrayList<CartVO> serviceCartList(String regid) {
		return cartMapper.selectAll(regid);
	}

	@Override
	public CartVO serviceCartView(int cseq, String regid) {
		return cartMapper.select(cseq, regid);
	}

}
