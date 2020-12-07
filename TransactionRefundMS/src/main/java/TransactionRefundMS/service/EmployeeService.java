package TransactionRefundMS.service;

import java.util.List;

import TransactionRefundMS.pojos.Employee;

public interface EmployeeService {

	public Employee readEmployee(int employeeId);
	
	public List<Employee> readAllEmployees();
	
	public int updateEmployee(int employeeId, Employee employee);

}
