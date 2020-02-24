package com.cts.swmd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	@Value("#{${app.title}}")
	private String appTitle;

	@GetMapping({ "", "/", "/home" })
	public ModelAndView deafaultGetRequestHandler() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");

		mv.addObject("pageTitle", "Home Page-welcome All");
		mv.addObject("developers", new String[] { "divya", "mahi" });
		return mv;
	}

	@RequestMapping("/header")
	public ModelAndView getHeaderPage() {
		return new ModelAndView("header", "appTitle", appTitle);
	}

	@RequestMapping("/footer")
	public String getFooterPage() {
		return "footer";
	}
	@GetMapping("/hello")
public ModelAndView sayHello(
		@RequestParam(name="salute",required=false,defaultValue="hie") String salutation,
		@RequestParam(name="divya",required=false,defaultValue="somebody") String userName) {
	ModelAndView mv=new ModelAndView();
	return new ModelAndView("hellopage","msg","Hello!"+salutation+userName);
}
}
