package TransactionRefundMS.pojos;

public class Reimbursement {
	
	private static int reimbursementCount;
	private int reimbursementId;
	private int employeeId;
	private int eventId;
	private String dateSubmition;
	private boolean employeeCancelation;
	private String justification;
	private double amountRequested;
	private double adjustedAmount;
	private String directorSupervisorApprovalDate;
	private String departmentHeadApprovalDate;
	private String benCoApprovalDate;
	private int reimbursementStatusId;
	private String notes;
	private int updateFileId;
	
	
	
	
	public Reimbursement(int reimbursementId, int employeeId, int eventId, String dateSubmition,
			boolean employeeCancelation, String justification, double amountRequested, double adjustedAmount,
			String directorSupervisorApprovalDate, String departmentHeadApprovalDate, String benCoApprovalDate,
			int reimbursementStatusId, String notes, int updateFileId) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.eventId = eventId;
		this.dateSubmition = dateSubmition;
		this.employeeCancelation = employeeCancelation;
		this.justification = justification;
		this.amountRequested = amountRequested;
		this.adjustedAmount = adjustedAmount;
		this.directorSupervisorApprovalDate = directorSupervisorApprovalDate;
		this.departmentHeadApprovalDate = departmentHeadApprovalDate;
		this.benCoApprovalDate = benCoApprovalDate;
		this.reimbursementStatusId = reimbursementStatusId;
		this.notes = notes;
		this.updateFileId = updateFileId;
	}



	public Reimbursement(int employeeId, int eventId, String justification, double amountRequested) {
		super();
		this.employeeId = employeeId;
		this.eventId = eventId;
		this.justification = justification;
		this.amountRequested = amountRequested;
	}
	
	

	public Reimbursement(int employeeId, int eventId, double amountRequested ,double adjustedAmount) {
		super();
		this.employeeId = employeeId;
		this.eventId = eventId;
		this.amountRequested = amountRequested;
		this.adjustedAmount=adjustedAmount;
	}

	public Reimbursement(String directorSupervisorApprovalDate, String departmentHeadApprovalDate, String notes) {
		super();
		this.directorSupervisorApprovalDate = directorSupervisorApprovalDate;
		this.departmentHeadApprovalDate = departmentHeadApprovalDate;
		this.notes = notes;
	}


	public Reimbursement(String benCoApprovalDate, int reimbursementStatusId, String notes) {
		super();
		this.benCoApprovalDate = benCoApprovalDate;
		this.reimbursementStatusId = reimbursementStatusId;
		this.notes = notes;
	}
	


	public Reimbursement(double amountRequested) {
		super();
		this.amountRequested = amountRequested;
	}


	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static int getReimbursementCount() {
		return reimbursementCount;
	}

	public static void setReimbursementCount(int reimbursementCount) {
		Reimbursement.reimbursementCount = reimbursementCount;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(int reimbursementId) {
		this.reimbursementId = reimbursementId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDateSubmition() {
		return dateSubmition;
	}

	public void setDateSubmition(String dateSubmition) {
		this.dateSubmition = dateSubmition;
	}

	public boolean isEmployeeCancelation() {
		return employeeCancelation;
	}

	public void setEmployeeCancelation(boolean employeeCancelation) {
		this.employeeCancelation = employeeCancelation;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public double getAmountRequested() {
		return amountRequested;
	}

	public void setAmountRequested(double amountRequested) {
		this.amountRequested = amountRequested;
	}

	public double getAdjustedAmount() {
		return adjustedAmount;
	}

	public void setAdjustedAmount(double adjustedAmount) {
		this.adjustedAmount = adjustedAmount;
	}

	public String getDirectorSupervisorApprovalDate() {
		return directorSupervisorApprovalDate;
	}

	public void setDirectorSupervisorApprovalDate(String directorSupervisorApprovalDate) {
		this.directorSupervisorApprovalDate = directorSupervisorApprovalDate;
	}

	public String getDepartmentHeadApprovalDate() {
		return departmentHeadApprovalDate;
	}

	public void setDepartmentHeadApprovalDate(String departmentHeadApprovalDate) {
		this.departmentHeadApprovalDate = departmentHeadApprovalDate;
	}

	public String getBenCoApprovalDate() {
		return benCoApprovalDate;
	}

	public void setBenCoApprovalDate(String benCoApprovalDate) {
		this.benCoApprovalDate = benCoApprovalDate;
	}

	public int getReimbursementStatusId() {
		return reimbursementStatusId;
	}

	public void setReimbursementStatusId(int reimbursementStatusId) {
		this.reimbursementStatusId = reimbursementStatusId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getUpdateFileId() {
		return updateFileId;
	}

	public void setUpdateFileId(int updateFileId) {
		this.updateFileId = updateFileId;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId + ", eventId="
				+ eventId + ", dateSubmition=" + dateSubmition + ", employeeCancelation=" + employeeCancelation
				+ ", justification=" + justification + ", amountRequested=" + amountRequested + ", adjustedAmount="
				+ adjustedAmount + ", directorSupervisorApprovalDate=" + directorSupervisorApprovalDate
				+ ", departmentHeadApprovalDate=" + departmentHeadApprovalDate + ", benCoApprovalDate="
				+ benCoApprovalDate + ", reimbursementStatusId=" + reimbursementStatusId + ", notes=" + notes
				+ ", updateFileId=" + updateFileId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(adjustedAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amountRequested);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((benCoApprovalDate == null) ? 0 : benCoApprovalDate.hashCode());
		result = prime * result + ((dateSubmition == null) ? 0 : dateSubmition.hashCode());
		result = prime * result + ((departmentHeadApprovalDate == null) ? 0 : departmentHeadApprovalDate.hashCode());
		result = prime * result
				+ ((directorSupervisorApprovalDate == null) ? 0 : directorSupervisorApprovalDate.hashCode());
		result = prime * result + (employeeCancelation ? 1231 : 1237);
		result = prime * result + employeeId;
		result = prime * result + eventId;
		result = prime * result + ((justification == null) ? 0 : justification.hashCode());
		result = prime * result + ((notes == null) ? 0 : notes.hashCode());
		result = prime * result + reimbursementId;
		result = prime * result + reimbursementStatusId;
		result = prime * result + updateFileId;
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
		Reimbursement other = (Reimbursement) obj;
		if (Double.doubleToLongBits(adjustedAmount) != Double.doubleToLongBits(other.adjustedAmount))
			return false;
		if (Double.doubleToLongBits(amountRequested) != Double.doubleToLongBits(other.amountRequested))
			return false;
		if (benCoApprovalDate == null) {
			if (other.benCoApprovalDate != null)
				return false;
		} else if (!benCoApprovalDate.equals(other.benCoApprovalDate))
			return false;
		if (dateSubmition == null) {
			if (other.dateSubmition != null)
				return false;
		} else if (!dateSubmition.equals(other.dateSubmition))
			return false;
		if (departmentHeadApprovalDate == null) {
			if (other.departmentHeadApprovalDate != null)
				return false;
		} else if (!departmentHeadApprovalDate.equals(other.departmentHeadApprovalDate))
			return false;
		if (directorSupervisorApprovalDate == null) {
			if (other.directorSupervisorApprovalDate != null)
				return false;
		} else if (!directorSupervisorApprovalDate.equals(other.directorSupervisorApprovalDate))
			return false;
		if (employeeCancelation != other.employeeCancelation)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (eventId != other.eventId)
			return false;
		if (justification == null) {
			if (other.justification != null)
				return false;
		} else if (!justification.equals(other.justification))
			return false;
		if (notes == null) {
			if (other.notes != null)
				return false;
		} else if (!notes.equals(other.notes))
			return false;
		if (reimbursementId != other.reimbursementId)
			return false;
		if (reimbursementStatusId != other.reimbursementStatusId)
			return false;
		if (updateFileId != other.updateFileId)
			return false;
		return true;
	}


	
	
	
	
}
