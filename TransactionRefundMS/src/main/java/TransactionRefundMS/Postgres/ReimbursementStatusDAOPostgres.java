package TransactionRefundMS.Postgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.ReimbursementStatusDAO;
import TransactionRefundMS.pojos.ReimbursementStatus;
import TransactionRefundMS.util.ConnectionUtil;

public class ReimbursementStatusDAOPostgres implements ReimbursementStatusDAO{
	
	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	
	@Override
	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId) {

		String sql = "select * from reimbursement_status where reimbursement_status_id = " + reimbursementStatusId;

		ReimbursementStatus reimbursementStatus = new ReimbursementStatus();

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read reimbursement status by id = " + reimbursementStatusId);

			while (rs.next()) {

				reimbursementStatusId = rs.getInt("reimbursement_status_id");
				String status = rs.getString("status");

				reimbursementStatus.setReimbursementStatusId(reimbursementStatusId);
				reimbursementStatus.setStatus(status);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementStatus;
	}

	@Override
	public List<ReimbursementStatus> readAllReimbursementStatuses() {

		List<ReimbursementStatus> reimbursementStatusList = new ArrayList();

		String sql = "select * from reimbursement_status";

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Dao read all events");

			while (rs.next()) {

				ReimbursementStatus reimbursementStatus = new ReimbursementStatus();

				int reimbursementStatusId = rs.getInt("reimbursement_status_id");
				String status = rs.getString("status");

				reimbursementStatus.setReimbursementStatusId(reimbursementStatusId);
				reimbursementStatus.setStatus(status);

				reimbursementStatusList.add(reimbursementStatus);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursementStatusList;
	}

}
