package TransactionRefundMS.Postgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.ReimbursementAmountDAO;
import TransactionRefundMS.pojos.ReimbursementAmount;
import TransactionRefundMS.util.ConnectionUtil;
public class ReimbursementAmountDAOPostgres implements ReimbursementAmountDAO{

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	@Override
	public void createReimbursementAmount(ReimbursementAmount reimbursementAmount) {
		String sql = "insert into reimbursement_amount (employee_id, awarded_amount, total_amount, available_amount)"
				+ "values(?, ?, ?, ?);";

		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, reimbursementAmount.getEmployeeId());
			stmt.setDouble(2, reimbursementAmount.getAwardedAmount());
			stmt.setDouble(3, reimbursementAmount.getTotalAmount());
			stmt.setDouble(4, reimbursementAmount.getAvailableAmount());

			stmt.executeUpdate();

			log.info("Controller creating reimbursement amount");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ReimbursementAmount readReimbursementAmount(int employeeId) {
		String sql = "select * from reimbursement_amount where reimbursement_amount_id = " + employeeId;

		ReimbursementAmount reimbursementAmount = new ReimbursementAmount();

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read reimbursement amount by id = " + employeeId);

			while (rs.next()) {

				int reimbursementAmountId = rs.getInt("reimbursement_amount_id");
				//int employeeId = rs.getInt("employee_id");
				double awardedAmount = rs.getDouble("awarded_amount");
				double totalAmount = rs.getDouble("total_amount");
				double availableAmount = rs.getDouble("available_amount");

				reimbursementAmount.setReimbursementAmountId(employeeId);
				reimbursementAmount.setEmployeeId(employeeId);
				reimbursementAmount.setAwardedAmount(awardedAmount);
				reimbursementAmount.setTotalAmount(totalAmount);
				reimbursementAmount.setAvailableAmount(availableAmount);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementAmount;
	}
	@Override
	public int updateReimbursementAmount(int reimbursementAmountId, ReimbursementAmount reimbursementAmount) {
		
		String sql = "update event"
				+ "set employee_id = ?, awarded_amount = ?, total_amount = ?, available_amount = ?" 
				+ "where reimbursement_amount_id = ?";

		int rows = 0;

		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, reimbursementAmount.getEmployeeId());
			stmt.setDouble(2, reimbursementAmount.getAwardedAmount());
			stmt.setDouble(3, reimbursementAmount.getTotalAmount());
			stmt.setDouble(4, reimbursementAmount.getAvailableAmount());
			stmt.setInt(5, reimbursementAmount.getReimbursementAmountId());


			rows = stmt.executeUpdate();

			log.info("Controller updating reimbursement amount by reimbursementAmountId = " + reimbursementAmountId);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rows;
	}

	@Override
	public int deleteReimbursementAmount(int reimbursementAmountId) {
		
		String sql = "delete from reimbursement_amount where reimbursement_amount_id = ?";
		
		int rowsToDelete = 0;

		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, reimbursementAmountId);

			rowsToDelete = stmt.executeUpdate();
		
			log.info("Controller deleting reimbursement amount by reimbursementAmountId = " + reimbursementAmountId);

			if (rowsToDelete == 0) {
				System.out.println("No rows to delete.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsToDelete;
				
	}

}
