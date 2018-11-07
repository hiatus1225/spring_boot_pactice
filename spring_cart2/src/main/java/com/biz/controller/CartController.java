package com.biz.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
//@Controller
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

//interface Controller
//import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.vo.BoardVO;
import com.biz.vo.CartVO;
import com.biz.vo.GoodsImgVO;
import com.biz.vo.GoodsVO;
import com.biz.vo.UserVO;
import com.biz.service.CartService;;

@Controller
public class CartController { // implements Controller {
	@Autowired
	private CartService cartService;
	@Autowired
	private UserVO vo;
	
	@RequestMapping(value = "/cart")
	public ModelAndView cart( ) {
		String regid="kim";
		ArrayList<CartVO> cartlist = cartService.serviceCartList(regid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartlist", cartlist);
		mav.setViewName("cart/list");
		return mav;
	}
	
	@RequestMapping(value = "/cart/{cseq}")
	public ModelAndView cartView(@PathVariable int cseq) {
		String regid="kim";
		CartVO cartVO= new CartVO();
		cartVO = cartService.serviceCartView(cseq, regid);
		
//		ArrayList<GoodsVO>alist=cartVO.getGoodsList();
//		for(int i = 0; i<alist.size();i++) {
//			System.out.println(alist.get(i).toString());
//			ArrayList<GoodsImgVO> ilist=alist.get(i).getGoodsImgVOs();
//			for(int j =0; j<ilist.size();j++) {
//				System.out.println(j);
//			}
//		}
//		System.out.println();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("cartVO", cartVO);
		mav.setViewName("cart/view");
		return mav;
	}
	

}
