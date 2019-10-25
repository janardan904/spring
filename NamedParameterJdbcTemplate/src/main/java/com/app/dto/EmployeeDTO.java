package com.app.dto;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
	private int empno;
	private String ename;
	private String job;
	private float salary;
	public EmployeeDTO(int empno, String ename, String job, float salary) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.salary = salary;
	}
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeeDTO [empno=" + empno + ", ename=" + ename + ", job=" + job + ", salary=" + salary + "]";
	}
      
}
