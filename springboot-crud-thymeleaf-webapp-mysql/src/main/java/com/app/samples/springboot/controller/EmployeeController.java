package com.app.samples.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.samples.springboot.entity.Employee;
import com.app.samples.springboot.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService; 
	
	//display list of employees
	@GetMapping("/")
	public String getAllEmployees(Model model) {
		List<Employee> employeesList = employeeService.getAllEmployees();
		model.addAttribute("employees", employeesList);
		return "index";
	}
	
}
