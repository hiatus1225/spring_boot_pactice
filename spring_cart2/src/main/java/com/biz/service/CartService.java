package com.biz.service;

import java.util.ArrayList;
import com.biz.vo.CartVO;

public interface CartService {

	public ArrayList<CartVO> serviceCartList(String regid);
	public CartVO serviceCartView(int cseq,String regid);
	
	
}
