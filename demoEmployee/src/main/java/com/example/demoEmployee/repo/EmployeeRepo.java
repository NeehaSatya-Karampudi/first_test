package com.example.demoEmployee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoEmployee.model.EmployeeModel;

public interface EmployeeRepo extends JpaRepository<EmployeeModel,Integer> {

	
}
