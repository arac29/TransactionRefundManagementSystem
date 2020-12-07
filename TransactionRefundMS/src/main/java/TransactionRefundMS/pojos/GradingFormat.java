package TransactionRefundMS.pojos;

public class GradingFormat {
	
	private int gradingFormatId;
	private String gradingFormat;
	public GradingFormat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GradingFormat(int gradingFormatId, String gradingFormat) {
		super();
		this.gradingFormatId = gradingFormatId;
		this.gradingFormat = gradingFormat;
	}
	public int getGradingFormatId() {
		return gradingFormatId;
	}
	public void setGradingFormatId(int gradingFormatId) {
		this.gradingFormatId = gradingFormatId;
	}
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gradingFormat == null) ? 0 : gradingFormat.hashCode());
		result = prime * result + gradingFormatId;
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
		GradingFormat other = (GradingFormat) obj;
		if (gradingFormat == null) {
			if (other.gradingFormat != null)
				return false;
		} else if (!gradingFormat.equals(other.gradingFormat))
			return false;
		if (gradingFormatId != other.gradingFormatId)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GradingFormat [gradingFormatId=" + gradingFormatId + ", gradingFormat=" + gradingFormat + "]";
	}
	
	
}
