package TransactionRefundMS.Postgres;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.EmployeeDAO;
import TransactionRefundMS.pojos.Employee;
import TransactionRefundMS.util.ConnectionUtil;

public class EmployeeDAOPostgres implements EmployeeDAO {
	
	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	Employee emp= new Employee();

	@Override
	public int signIn(String username, String password) {
		int rows=0;
		
		String sql="select * from login where username=? and password=? ;";
		
		try ( Connection conn = connUtil.createConnection()){
			prepSt= conn.prepareStatement(sql);
			prepSt.setString(1, (username));
			prepSt.setString(2, (password));
			ResultSet rs = prepSt.executeQuery();
			
			log.info(" result set " + rs);
			
			while(rs.next()) {
				
				int employee_id= rs.getInt("employee_id");
				//employee.setEmployeeId(userId);
				
				log.info(" Postgres dao authenticated " +employee_id);
				return employee_id;
			}
			//rows=prepSt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		log.info(" Postgres dao ----- Failed to authenticate " + username );
		return 0;
	}

	@Override
	public Employee readEmployee(int employeeId) {
		
		String sql = "select * from employee where employee_id =" + employeeId;

		Employee employee = new Employee();

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read employee by id = " + employeeId);

			while (rs.next()) {

				employeeId = rs.getInt("employee_id");
				String title = rs.getString("title");
				int reportTo = rs.getInt("reports_to");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String dateBirth = rs.getString("date_birth");
				String phoneNumber = rs.getString("phone_number");
				String email = rs.getString("email");
				String address = rs.getString("address");
				String city = rs.getString("city");
				String state = rs.getString("state");
				String country = rs.getString("country");
				String postalCode = rs.getString("postal_code");

				employee.setEmployeeId(employeeId);
				employee.setTitle(title);
				employee.setBoss_id(reportTo);
				employee.setFirstName(firstName);
				employee.setLastName(lastName);
				employee.setDateBirth(dateBirth);
				employee.setPhoneNumber(phoneNumber);
				employee.setEmail(email);
				employee.setAddress(address);
				employee.setCity(city);
				employee.setState(state);
				employee.setCountry(country);
				employee.setPostalCode(postalCode);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public List<Employee> readAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateEmployee(int employeeId, Employee employee) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
