package com.app.samples.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	/**
	 * Find paginated employee.
	 *
	 * @param pageNumber the page number
	 * @param pageSize the page size
	 * @param sortField the sort field
	 * @param sortDirection the sort direction
	 * @return the page
	 */
	@Override
	public Page<Employee> findPaginatedEmployee(int pageNumber, int pageSize, String sortField, String sortDirection) {
		Sort sort = null;
		if(sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name())) {
			sort = Sort.by(sortField).ascending();
		}else {
			sort = Sort.by(sortField).descending();
		}
		Pageable pageable = PageRequest.of(pageNumber-1, pageSize, sort);
		return employeeRepository.findAll(pageable);	
	}
}
