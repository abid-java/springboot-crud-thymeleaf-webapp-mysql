package com.app.samples.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.samples.springboot.entity.Employee;
import com.app.samples.springboot.repository.EmployeeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeServiceImpl.
 */
public class EmployeeServiceImpl implements EmployeeService{

	/** The employee repository. */
	@Autowired
	private EmployeeRepository employeeRepository; 
	
	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}