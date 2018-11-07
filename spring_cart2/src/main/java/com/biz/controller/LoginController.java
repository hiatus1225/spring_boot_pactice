package com.biz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
//@Controller
import org.springframework.stereotype.Controller;

//interface Controller
//import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.service.UserService;
import com.biz.vo.UserVO;

@Controller
//1. @Controller 
//   (new=bean, extends/implements ###Controller

public class LoginController { // implements Controller {
	@Autowired
	private UserService userService;
	@Autowired
	private UserVO vo;
	
//	public void setUserServiceSETTER(UserService a100) {
//		this.userService = a100;
//	}
//	public void setUserVOSETTER(UserVO a200) {
//		this.vo = a200;
//	}
	
	
//	public LoginController(UserService a100
//			, UserVO a200
//			,String path) {
//		this.userService = a100;
//		vo = a200;
//		System.out.println(path+"---------------");
//	}
	
	
	@RequestMapping(value = "/login") //, method = RequestMethod.POST)
	//public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
	
	//@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
//		mav.addObject("LVL", list);
//		mav.setViewName("user_main");
		
		//1. 사용자 입력정보(id,pw) 추출 코드
		//--------------------DI ------------------------
		//UserVO vo = new UserVO();
		//--------------------DI ------------------------
		
		
		vo.setId(request.getParameter("id"));
		vo.setPw(request.getParameter("pw"));
		
		//2. 사용자 입력 정보 이용 UserVO 객체 조회
		//setter()로 UserService객체 못 받아올 경우 아래 주석풀고 실행
		//--------------------DI ------------------------
		//UserService userService = new UserServiceImpl();
		//--------------------DI ------------------------
		vo = userService.getUser(vo);
		
		//3. DB 연동 로직 구현(USERDAO 객체 사용)
		String viewName="";
		if(!vo.getName().equals("")) {
			HttpSession session = request.getSession();
			session.setAttribute("SESS_ID", vo.getId());
			session.setAttribute("SESS_NAME", vo.getName());
			/////viewName = "user/main";
			mav.setViewName("user/main");
		} else {
			/////viewName = "user/login";
			mav.setViewName("user/login");
		} 
		//////return viewName;
		return mav;
	}


}
