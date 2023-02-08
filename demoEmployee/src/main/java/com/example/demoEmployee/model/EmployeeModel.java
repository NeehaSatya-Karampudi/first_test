package com.example.demoEmployee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class EmployeeModel {
	
	//provide primary key which is automatically generated always
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int eid;
	private String ename;
	private String email;
	private String jobrole;
	private String address;
	private int salary;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getJobrole() {
		return jobrole;
	}
	public void setJobrole(String jobrole) {
		this.jobrole = jobrole;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public EmployeeModel(int empId, String ename, String email, String jobrole, String address, int salary) {
		super();
		this.eid = empId;
		this.ename = ename;
		this.email = email;
		this.jobrole = jobrole;
		this.address = address;
		this.salary = salary;
	}
	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeModel [eid=" + eid + ", ename=" + ename + ", email=" + email + ", jobrole=" + jobrole
				+ ", address=" + address + ", salary=" + salary + "]";
	}
	
}
