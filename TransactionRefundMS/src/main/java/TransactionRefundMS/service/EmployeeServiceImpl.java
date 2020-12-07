package TransactionRefundMS.service;

import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.*;
import TransactionRefundMS.Postgres.*;
import TransactionRefundMS.pojos.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAO employeeDao = new EmployeeDAOPostgres();


	private static Logger log = Logger.getRootLogger();

	
	@Override
	public Employee readEmployee(int employeeId) {
		log.info("Employee Service - Read Employee by ID");
		return employeeDao.readEmployee(employeeId);
	}


	@Override
	public List<Employee> readAllEmployees() {
		log.info("Employee Service - Read All Employees");
		return employeeDao.readAllEmployees();
	}

	@Override
	public int updateEmployee(int employeeId, Employee employee) {
		log.info("Employee Service - update employees");
		return employeeDao.updateEmployee(employeeId, employee);
	}
}
