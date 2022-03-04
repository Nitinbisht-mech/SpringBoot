package com.dailycodebuffer.Springboot.tutorial.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.Springboot.tutorial.entity.Department;
import com.dailycodebuffer.Springboot.tutorial.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);
	@GetMapping("/home")
	public String home() {
		return "I am home 55";
	}
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		
		LOGGER.info("Inside saveDepartment of DepartmentContrller");
		return departmentService.saveDepartment(department);
		
	}
	
	@GetMapping("/departments")
	public List<Department> fetchDepartmentList(){
		
		LOGGER.info("Inside fetchDepartmentList of DepartmentContrller");
		return departmentService.fetchDepartmentList();
		
	}
	
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id") Long departmentId) {
		
		LOGGER.info("Inside fetchDepartmentById of DepartmentContrller");
		return departmentService.fetchDepartmentById(departmentId);
		
	}
	
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id")Long departmentId) {
		
		LOGGER.info("Inside deleteDepartmentById of DepartmentContrller");
		 departmentService.deleteDepartmentById(departmentId);
		 return "Department deleted successfully";
		
	}
	
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id") Long departmentId, @Valid @RequestBody Department department) {
		
		LOGGER.info("Inside updateDepartment of DepartmentContrller");
		return departmentService.updateDepartment(departmentId, department);
	}
	
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name") String departName) {
		
		LOGGER.info("Inside fetchDepartmentByName of DepartmentContrller");
		return departmentService.fetchDepartmentByName(departName);
	}

}
