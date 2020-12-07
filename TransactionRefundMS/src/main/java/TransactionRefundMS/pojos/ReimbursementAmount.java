package TransactionRefundMS.pojos;

public class ReimbursementAmount {
	
	private int reimbursementAmountId;
	private int employeeId;
	private double awardedAmount;
	private double totalAmount;
	private double availableAmount;
	public ReimbursementAmount() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReimbursementAmount(int reimbursementAmountId, int employeeId, double awardedAmount, double totalAmount,
			double availableAmount) {
		super();
		this.reimbursementAmountId = reimbursementAmountId;
		this.employeeId = employeeId;
		this.awardedAmount = awardedAmount;
		this.totalAmount = totalAmount;
		this.availableAmount = availableAmount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(availableAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(awardedAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + employeeId;
		result = prime * result + reimbursementAmountId;
		temp = Double.doubleToLongBits(totalAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		ReimbursementAmount other = (ReimbursementAmount) obj;
		if (Double.doubleToLongBits(availableAmount) != Double.doubleToLongBits(other.availableAmount))
			return false;
		if (Double.doubleToLongBits(awardedAmount) != Double.doubleToLongBits(other.awardedAmount))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (reimbursementAmountId != other.reimbursementAmountId)
			return false;
		if (Double.doubleToLongBits(totalAmount) != Double.doubleToLongBits(other.totalAmount))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReimbursementAmount [reimbursementAmountId=" + reimbursementAmountId + ", employeeId=" + employeeId
				+ ", awardedAmount=" + awardedAmount + ", totalAmount=" + totalAmount + ", availableAmount="
				+ availableAmount + "]";
	}
	public int getReimbursementAmountId() {
		return reimbursementAmountId;
	}
	public void setReimbursementAmountId(int reimbursementAmountId) {
		this.reimbursementAmountId = reimbursementAmountId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getAwardedAmount() {
		return awardedAmount;
	}
	public void setAwardedAmount(double awardedAmount) {
		this.awardedAmount = awardedAmount;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getAvailableAmount() {
		return availableAmount;
	}
	public void setAvailableAmount(double availableAmount) {
		this.availableAmount = availableAmount;
	}
	
	
	
}
