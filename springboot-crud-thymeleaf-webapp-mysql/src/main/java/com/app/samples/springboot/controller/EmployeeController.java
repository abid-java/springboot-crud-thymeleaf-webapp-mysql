package com.app.samples.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.samples.springboot.entity.Employee;
import com.app.samples.springboot.service.EmployeeService;

// TODO: Auto-generated Javadoc
/**
 * The Class EmployeeController.
 */
@Controller
public class EmployeeController {

	/** The employee service. */
	@Autowired
	private EmployeeService employeeService; 
	
	/**
	 * Gets the all employees.
	 *
	 * @param model the model
	 * @return the all employees
	 */
	//display list of employees
	@GetMapping("/")
	public String getAllEmployees(Model model) {
		//	List<Employee> employeesList = employeeService.getAllEmployees();
		//	model.addAttribute("employees", employeesList);
		//	return "index";
		return viewPaginated(1, model);
	}
	
	/**
	 * Show new employee form.
	 *
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";		
	}
	
	/**
	 * Save employee.
	 *
	 * @param employee the employee
	 * @return the string
	 */
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmpoyee(employee);
		return "redirect:/";
	}
	
	/**
	 * Show update form.
	 *
	 * @param employeeId the employee id
	 * @param model the model
	 * @return the string
	 */
	@GetMapping("/showUpdateForm/{id}")
	public String showUpdateForm(@PathVariable("id") long employeeId, Model model) {
		//get the employee for a given employee id
		Employee existingEmployee = employeeService.getEmployeeById(employeeId);
		
		//set that employee as a model attribute to pre-populate the form
		model.addAttribute("existingEmployee", existingEmployee);
		return "update_employee";
	}
	
	/**
	 * Delete employee.
	 *
	 * @param employeeId the employee id
	 * @return the string
	 */
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable("id") long employeeId) {
		employeeService.deleteEmployee(employeeId);
		return "redirect:/";
	}
	
	@GetMapping("/page/{pageNumber}")
	public String viewPaginated(@PathVariable("pageNumber") int pageNumber, Model model) {
		int pageSize = 5;
		Page<Employee> paginatedEmployee = employeeService.findPaginatedEmployee(pageNumber, pageSize);
		List<Employee> employeesList = paginatedEmployee.getContent();
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("totalPages", paginatedEmployee.getTotalPages());
		model.addAttribute("totalEmployees", paginatedEmployee.getTotalElements());
		model.addAttribute("employeesList", employeesList);
		return "index";
	}
	
}
