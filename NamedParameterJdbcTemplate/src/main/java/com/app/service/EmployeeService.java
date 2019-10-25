package com.app.service;

import com.app.bo.EmployeeBO;
import com.app.dao.EmployeeDAO;
import com.app.dto.EmployeeDTO;

public class EmployeeService {
	
	private EmployeeDAO dao;

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}
	
	public String searchNameByNo(int empno) {
		
		String ename=dao.findName(empno);
		
		return ename;
	}
	
	public EmployeeDTO searchEmployeeByNo(int empno) {
		//use dao
		EmployeeBO bo=dao.findEmpDetails(empno);
		//convert bo into Dto
		
		EmployeeDTO dto=new EmployeeDTO(bo.getEmpno(),
				bo.getEname(),
				bo.getJob(),
				bo.getSalary());
		
		return dto ;
		
	}
	public String registerEmp(int empno,String ename,String job,float salary) {
		//create dto
		EmployeeDTO dto=new EmployeeDTO(empno, ename, job, salary);
		//convert dto to bo
		EmployeeBO bo=new EmployeeBO(dto.getEmpno(),
				dto.getEname(),
				dto.getJob(),
				dto.getSalary());
		
		int result=dao.insertRecored(bo);
		if(result==1)
			return"Registration success";
		
		else 
		return "Registration failed";
		
	}

}
