package com.cts.swapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	@RequestMapping({"","/","/home"})
	public ModelAndView defaultGetRequestHandler() {
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("home");
		mv.addObject("pageTitle","home page-welcome All");
		mv.addObject("developers",new String[] {"mahesh","rishab","dhivya"});
		
		return mv;
	}
}
