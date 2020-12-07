package TransactionRefundMS.DAO;

import TransactionRefundMS.pojos.ReimbursementAmount;

public interface ReimbursementAmountDAO {
	public void createReimbursementAmount(ReimbursementAmount reimbursementAmount);
	
	public ReimbursementAmount readReimbursementAmount(int employeeId);

	public int deleteReimbursementAmount(int reimbursementAmountId);

	public int updateReimbursementAmount(int reimbursementAmountId, ReimbursementAmount reimbursementAmount);
}
