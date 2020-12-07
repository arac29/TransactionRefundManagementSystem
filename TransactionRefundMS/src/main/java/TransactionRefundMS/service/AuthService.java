package TransactionRefundMS.service;

public interface AuthService {
	
	public int authenticatedUser(String username, String password);
	
	public String createToken(int employee_id);
	
	public String validateToken(String token);
	
	
}
