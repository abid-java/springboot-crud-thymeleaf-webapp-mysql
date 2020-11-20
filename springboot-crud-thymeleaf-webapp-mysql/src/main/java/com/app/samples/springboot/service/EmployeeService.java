package com.app.samples.springboot.service;

import java.util.List;

import com.app.samples.springboot.entity.Employee;

// TODO: Auto-generated Javadoc
/**
 * The Interface EmployeeService.
 */
public interface EmployeeService {

	/**
	 * Gets the all employees.
	 *
	 * @return the all employees
	 */
	public List<Employee> getAllEmployees();
	
	/**
	 * Save empoyee.
	 *
	 * @param employee the employee
	 */
	public void saveEmpoyee(Employee employee);
	
	/**
	 * Gets the employee by id.
	 *
	 * @param employeeId the employee id
	 * @return the employee by id
	 */
	public Employee getEmployeeById(long employeeId);
	
	
	/**
	 * Delete employee.
	 *
	 * @param id the id
	 */
	public void deleteEmployee(long id);
}
