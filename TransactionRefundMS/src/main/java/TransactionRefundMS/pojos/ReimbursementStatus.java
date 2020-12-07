package TransactionRefundMS.pojos;

public class ReimbursementStatus {

	private int reimbursementStatusId;
	private String status;
	public ReimbursementStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementStatus(int reimbursementStatusId, String status) {
		super();
		this.reimbursementStatusId = reimbursementStatusId;
		this.status = status;
	}
	@Override
	public String toString() {
		return "ReimbursementStatus [reimbursementStatusId=" + reimbursementStatusId + ", status=" + status + "]";
	}
	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}
	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + reimbursementStatusId;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementStatus other = (ReimbursementStatus) obj;
		if (reimbursementStatusId != other.reimbursementStatusId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	
	
}
