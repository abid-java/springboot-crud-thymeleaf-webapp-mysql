package com.app.samples.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.samples.springboot.entity.Employee;
import com.app.samples.springboot.repository.EmployeeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeServiceImpl.
 */
@Service
@Transactional
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

	/**
	 * Save empoyee.
	 *
	 * @param employee the employee
	 */
	@Override
	public void saveEmpoyee(Employee employee) {
		employeeRepository.save(employee);
		
	}

	/**
	 * Gets the employee by id.
	 *
	 * @param employeeId the employee id
	 * @return the employee by id
	 */
	@Override
	public Employee getEmployeeById(long employeeId) {
		Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);
		Employee employee = null;
		if(existingEmployee.isPresent()) {
			employee = existingEmployee.get();
		}
		else {
			throw new RuntimeException("Employee Not found with Id : " + employeeId);
		}
		return employee;
	}

	/**
	 * Delete employee.
	 *
	 * @param employeeId the employee id
	 */
	@Override
	public void deleteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}

}
