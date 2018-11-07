package com.kosmo.url;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MultiController extends MultiActionController {

	protected ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MultiController::insert call....");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
			return modelAndView;
		}
	
	public ModelAndView select(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("MultiController::select call....");
		
		return null;
	}
	
}
