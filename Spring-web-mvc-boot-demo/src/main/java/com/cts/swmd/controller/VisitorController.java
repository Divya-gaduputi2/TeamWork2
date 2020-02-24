package com.cts.swmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmd.model.Visitor;
import com.cts.swmd.service.VisitorService;

@Controller
@RequestMapping("/visitor")

public class VisitorController {
	@Autowired
	private VisitorService vServ;

	@GetMapping
	public String showVisitorForm() {
		return "visitorInputPage";
	}

	@PostMapping
	public ModelAndView acceptVisitorData(@ModelAttribute Visitor visitor) {

		visitor = vServ.computeAge(visitor);
		return new ModelAndView("visitorOutputPage", "v", visitor);
	}
}
