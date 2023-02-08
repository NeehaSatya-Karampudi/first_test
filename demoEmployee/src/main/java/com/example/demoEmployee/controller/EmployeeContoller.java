package com.example.demoEmployee.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoEmployee.model.EmployeeModel;
import com.example.demoEmployee.repo.EmployeeRepo;

@RequestMapping("/testAPI")
@RestController
public class EmployeeContoller {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@PostMapping(path="/employee")
	@ResponseBody
	public ResponseEntity<EmployeeModel> postEmp(@RequestBody EmployeeModel empData) throws Exception{
		return new ResponseEntity<>(employeeRepo.save(empData),HttpStatus.CREATED);
		//System.out.println(employee);		
		
	}
	@GetMapping(path = "/employee")
	public ResponseEntity<List<EmployeeModel>> getAllEmployee(){
		return new ResponseEntity<>(employeeRepo.findAll(),HttpStatus.OK);
	}
	
	@GetMapping(path = "/employee/{eid}")
	public ResponseEntity<EmployeeModel> getEmployee(@PathVariable int eid){
		Optional<EmployeeModel> employee = employeeRepo.findById(eid);
		if(employee.isPresent()) {
			return new ResponseEntity<>(employee.get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(path = "/employee/{eid}")
	public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable int eid,@RequestBody EmployeeModel empData ){
		Optional<EmployeeModel> employee = employeeRepo.findById(eid);
		if(employee.isPresent()) {
			employee.get().setEname(empData.getEname());
			employee.get().setEmail(empData.getEmail());
			employee.get().setJobrole(empData.getJobrole());
			employee.get().setAddress(empData.getAddress());
			employee.get().setSalary(empData.getSalary());
			return new ResponseEntity<>(employeeRepo.save(employee.get()),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(path = "/employee/{eid}")
	public ResponseEntity<EmployeeModel> deleteEmployee(@PathVariable int eid){
		Optional<EmployeeModel> employee = employeeRepo.findById(eid);
		if(employee.isPresent()) {
			employeeRepo.deleteById(eid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
