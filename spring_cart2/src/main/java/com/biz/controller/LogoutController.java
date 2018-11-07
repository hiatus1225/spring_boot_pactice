package com.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@Controller
import org.springframework.stereotype.Controller;

//interface Controller
//import org.springframework.web.servlet.mvc.Controller;


@Controller
public class LogoutController { //implements Controller {
	@RequestMapping(value = "/logout")
	//public String handlerRequest(HttpServletRequest request , HttpServletResponse response) {
	
	//@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		
		HttpSession session = request.getSession();
		session.invalidate();
		mav.setViewName("user/login");
		return mav;
		//return "user/login";
	}
}
