package TransactionRefundMS.service;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.EmployeeDAO;
import TransactionRefundMS.Postgres.EmployeeDAOPostgres;
import TransactionRefundMS.pojos.Employee;
import TransactionRefundMS.util.ConnectionUtil;

public class AuthServiceImpl implements AuthService{
	
	
	private Statement statement;
	private PreparedStatement prepSt;

	private ConnectionUtil connUtil = new ConnectionUtil();
	
	
	private static Logger log = Logger.getRootLogger();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	//private static Logger log = Logger.getRootLogger();
	
	private static byte[] salt = new SecureRandom().getSeed(16);

	private Map<String, String> tokenRepo = new HashMap<>();
	
	EmployeeDAO emplDao = new EmployeeDAOPostgres();
	static Employee emp = new Employee();
	@Override
	public int authenticatedUser(String username, String password) {
		
		int user_id=emplDao.signIn(username, password);
		log.info("auth service pass");

		return user_id;
		
	}

	@Override
	public String createToken(int employee_id) {
		
		String id=String.valueOf(employee_id);
		String token = simpleHash(id);

		tokenRepo.put(token, id);

		return token;
	}

	@Override
	public String validateToken(String token) {
		return tokenRepo.get(token);
	}
	
	private String simpleHash(String id) {
		
		String hash = null;
		
		MessageDigest md;
		
		try {
			
			md = MessageDigest.getInstance("SHA-512");
			md.update(salt);
			
			byte[] bytes = md.digest(id.getBytes());

			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < bytes.length; i++) {
				
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(0));
			}
			
			hash = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
		
			e.printStackTrace();
		}
		
		return hash;
	}
}
