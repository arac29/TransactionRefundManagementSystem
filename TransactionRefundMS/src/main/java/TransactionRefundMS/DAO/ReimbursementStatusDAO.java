package TransactionRefundMS.DAO;

import java.util.List;

import TransactionRefundMS.pojos.ReimbursementStatus;

public interface ReimbursementStatusDAO {
	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId);
	
	public List<ReimbursementStatus> readAllReimbursementStatuses();
}
