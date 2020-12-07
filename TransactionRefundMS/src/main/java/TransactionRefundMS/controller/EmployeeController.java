package TransactionRefundMS.controller;

import org.apache.log4j.Logger;

import TransactionRefundMS.pojos.Employee;
import TransactionRefundMS.service.EmployeeService;
import TransactionRefundMS.service.EmployeeServiceImpl;
import io.javalin.http.Context;

public class EmployeeController {
	EmployeeService employeeService = new EmployeeServiceImpl();
	
	private static Logger log = Logger.getRootLogger();
	
	public void getEmployee(Context ctx) {
		
		log.info("Controller -- read  employee id");
		
		int employeeId = Integer.parseInt(ctx.formParam("employeeId"));
		
		ctx.html(employeeService.readEmployee(employeeId).toString());
		
	}
	
	public void getAllEmployees(Context ctx) {
		
		log.info("Controller -- read all employees");
		
		ctx.html(employeeService.readAllEmployees().toString());
		
	}
	
	public void updateEmployee(Context ctx) {
		
		log.info("Controller -- update employee");
		
		System.out.println("Responding update employee request");
		
		int employeeId = Integer.parseInt(ctx.formParam("employeeId"));
		
		String title = ctx.formParam("title");
		
		int reportTo = Integer.parseInt(ctx.formParam("reportTo"));
		
		String firstName = ctx.formParam("firstName");
		

		
		String lastName = ctx.formParam("lastName");
		
		String dateBirth = ctx.formParam("dateBirth");
		
		String phoneNumber = ctx.formParam("phoneNumber");
		
		String email = ctx.formParam("email");
		
		String address = ctx.formParam("address");
		
		String city = ctx.formParam("city");
		
		String state = ctx.formParam("state");
		
		String country = ctx.formParam("country");
		
		String postalCode = ctx.formParam("postalCode");
		
		Employee employee = new Employee(employeeId, title, reportTo, firstName,  lastName, dateBirth, phoneNumber, email, address,
											city, state, country, postalCode);
		
		employeeService.updateEmployee(employeeId, employee);
		
		ctx.html(Integer.toString(employee.getEmployeeId()));
		
	}
}
