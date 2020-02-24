package com.cts.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.cts.demo.Exception.EmployeeException;
import com.cts.demo.model.Department;
import com.cts.demo.model.Employee;

public interface EmployeeService {
	
	Employee add(Employee emp) throws EmployeeException;
	Employee save(Employee emp) throws EmployeeException;
	
	void deleteById(Long empId);
	
	Employee findById(Long empId);
	Employee findByMobileNumber(String mobileNumber);
	Employee findByEmail(String email);
	
	List<Employee> findAll();
	List<Employee> fingAllByDept(Department dept);
	List<Employee> fingAllByJoinDate(LocalDate joinDate);
	
	List<Employee> findAllByBasicRange(double lb,double ub);
	
	

}
