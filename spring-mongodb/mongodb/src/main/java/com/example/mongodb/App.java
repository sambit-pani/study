package com.example.mongodb;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.example.mongodb.service.DepartmentService;
import com.example.mongodb.service.EmployeeService;
import com.mongodb.MongoClient;

/**
 * Hello world!
 *
 */
public class App 
{
	 	@Autowired
		private DepartmentService deptService;
	 	
	 	@Autowired
	 	private EmployeeService empService;
	 	
	 	public static void main(String[] args) throws Exception {
			ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
			App app = context.getBean(App.class,"app");
			//app.getDeptService().saveDepartment();
			app.getEmpService().update();//();
		}
		  
	 	
		public DepartmentService getDeptService() {
			return deptService;
		}
		public void setDeptService(DepartmentService deptService) {
			this.deptService = deptService;
		}
	  
		
	  public EmployeeService getEmpService() {
			return empService;
		}
		public void setEmpService(EmployeeService empService) {
			this.empService = empService;
		}
	
}
