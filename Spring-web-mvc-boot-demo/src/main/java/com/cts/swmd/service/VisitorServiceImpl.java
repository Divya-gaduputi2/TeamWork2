package com.cts.swmd.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;

import com.cts.swmd.exception.InvalidVisitorException;
import com.cts.swmd.model.Visitor;
@Service
public class VisitorServiceImpl implements VisitorService {

	@Override
	public Visitor computeAge(VisitorService visitor) {
		if(visitor!=null) {
			LocalDate today=LocalDate.now();
			int age=Period.between(visitor.getDateOfFirst(),today).getYear();
			visitor.setAge(age);
		}
		return visitor;
	}
@Override
public boolean isValid(Visitor visitor)throws InvalidVisitorException{
	boolean isOk=true;
	
	if(LocalDate.now().isBefore(visitor))
}
}
