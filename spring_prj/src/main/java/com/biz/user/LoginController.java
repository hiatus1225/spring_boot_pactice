package com.biz.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.servlet.mvc.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.biz.user.UserService;

@Controller
//1. @Controller (new, extends/implements ###Controller)    컨트롤로 인식되기위한 방법 1
//2. bean등록 후 상속(Controller)
public class LoginController {//implements Controller {
	@Autowired
	private UserService userServiceSetter;
	@Autowired
	private UserVO userVO;
//	private String paths;

	
//	public LoginController(UserService usersService, UserVO vos, String path) {
//		this.userService=usersService;
//		this.vo=vos;
//		this.paths=path;
//		System.out.println(path+"--path 등록완료");
//	}
	
//	public void setUserServiceSetter(UserService userService) {
//		this.userServiceSetter=userService;
//	}
//	
//	public void setUserVOSetter(UserVO userVO) {
//		this.userVO=userVO;
//	}
	
	
//	public String handlerRequest(HttpServletRequest request, HttpServletResponse response) {
//	@Override
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String key = request.getParameter("key");
//		if(key.equals("login.do")) {
//		}else if(key.equals("login.do")) {
//		}
		//1. 사용자 입력정보(id,pw) 추출 코드
		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.addObject("", attributeValue);//객체 담기
//		modelAndView.setView(view);// view담기
		
//		---------------di-----------------
//		UserVO vo = new UserVO(); 
//		---------------di-----------------
		
		userVO.setId(request.getParameter("id"));
		userVO.setPw(request.getParameter("pw"));
		
		//2. 사용자 입력 정보 이용 UserVO 객체 조회
		//setter()로 UserService객체 못 받아올 경우 아래 주석풀고 실행
//		-------------------<DI>-------------------------
//		UserService userService = new UserServiceImpl();
//		-------------------<DI>-------------------------
		userVO = userServiceSetter.getUser(userVO);
		
		
		//3. DB 연동 로직 구현(USERDAO 객체 사용)
		String viewName="";
		if(!userVO.getName().equals("")) {
			HttpSession session = request.getSession();
			session.setAttribute("SESS_ID", userVO.getId());
			session.setAttribute("SESS_NAME", userVO.getName());
			modelAndView.setViewName("user/main");
		} else {
			modelAndView.setViewName("user/login");
		} 
		return modelAndView;
	}
	
}
