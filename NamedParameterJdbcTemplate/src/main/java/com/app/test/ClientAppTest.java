package com.app.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.app.service.EmployeeService;

public class ClientAppTest {

	public static void main(String[] args) {
		
		//create ioc container
		ApplicationContext ctx=null;
		ctx= new ClassPathXmlApplicationContext("com/app/cfgs/applicationContext.xml");
		//get bean object 
		EmployeeService service=ctx.getBean("empservice",EmployeeService.class);
		
		System.out.println("7499 emp name:"+service.searchNameByNo(7499));
		System.out.println("7498 emp name:"+service.searchNameByNo(7498));
		System.out.println("7497 emp name:"+service.searchNameByNo(7497));
		System.out.println("Emp name:"+service.registerEmp(7492,"raj","Engg",2000.0f));
	}

}
