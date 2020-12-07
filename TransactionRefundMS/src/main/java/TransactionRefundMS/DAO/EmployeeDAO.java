package TransactionRefundMS.DAO;

import java.util.List;

import TransactionRefundMS.pojos.Employee;

public interface EmployeeDAO {
	
	
	public int signIn(String username, String password);

	public Employee readEmployee(int employeeId);

	public List<Employee> readAllEmployees();

	public int updateEmployee(int employeeId, Employee employee);
	
	
}	
