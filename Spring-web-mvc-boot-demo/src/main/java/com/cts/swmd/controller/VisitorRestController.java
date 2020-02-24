package com.cts.swmd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.swmd.exception.InvalidVisitorException;
import com.cts.swmd.model.Visitor;
import com.cts.swmd.service.VisitorService;

//@Controller
@RestController
@RequestMapping("/vapi")

public class VisitorRestController {
	@Autowired
	private VisitorService vServ;

	
	@PostMapping
	public ResponseEntity<Visitor>acceptVisitorData(@RequestBody Visitor visitor) {
if (vServ.isValid(visitor)) {
	

		visitor = vServ.computeAge(visitor);
}
		return new ResponseEntity<Visitor>( visitor,HttpStatus.OK);
	}
	@ExceptionHandler(InvalidVisitorException.class)
	public ResponseEntity<String>handleInvalidVisitorException(InvalidVisitorException exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
