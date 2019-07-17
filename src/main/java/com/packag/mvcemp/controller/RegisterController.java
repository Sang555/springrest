package com.packag.mvcemp.controller;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
//Rest
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.objenesis.instantiator.basic.NewInstanceInstantiator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.packag.mvcemp.model.Employee;
import com.packag.mvcemp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus;//@Controller
@RestController
@RequestMapping("/employees")
public class RegisterController {
	
	@Autowired
	private EmployeeService employeeService;
	/*
	
 @GetMapping("/login")
 public String login()
 {
	 return "login";
 }*/
 
 


 @GetMapping(value="/" , produces= { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
 @ResponseStatus(HttpStatus.OK)
 public List<Employee> displayAll()
 {
		

		List<Employee> empList= employeeService.listAll();
		return empList;
 }
 
 @GetMapping(value="/{id}", produces= {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
 @ResponseStatus(HttpStatus.OK)
 public Employee displayEmp(@PathVariable("id") int id)
 {
	
		Employee employee=employeeService.retreiveById(id);
		
	 return employee ;
 }
 /*
 @GetMapping("/register")
 public String registerForm(Model model)
 {
	 model.addAttribute("employee", new Employee());
	 return "register";
 }
 
 
 @PostMapping("/register")
 public String registerEMployee(@ModelAttribute("employee") @Valid Employee employee, BindingResult result )
 {
	 System.out.println(employee);

	 System.out.println("Registered successfully");
	 if (result.hasErrors()) {
         return "register";
      }
	 employeeService.insertEmployee(employee);
	 return "success";
 }*/
 
 
 
 @PostMapping(value= "/", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
 @ResponseStatus(HttpStatus.OK)
 public void registerEMployee( @Valid @RequestBody Employee employee )
 {
	 System.out.println(employee);
	 employeeService.insertEmployee(employee);
	 System.out.println("Inside Register");
	
 }
 /*
 @GetMapping("/delete")
 public String deleteEmployee(Model model)
 {
	 model.addAttribute("employeeid",new String());
	 return "delete";
 }
 
 @PostMapping("/delete")
 public String deleteEmp(@ModelAttribute("employeeid") String employeeid )
 {
	

	// employeeService.delete(employeeid);
	 return "success";
 }
 */
 
}
