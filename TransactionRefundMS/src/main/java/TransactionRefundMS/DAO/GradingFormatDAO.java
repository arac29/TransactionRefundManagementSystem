package TransactionRefundMS.DAO;

import java.util.List;

import TransactionRefundMS.pojos.GradingFormat;

public interface GradingFormatDAO {
	public GradingFormat readGradingFormat(int gradingFormatCompanyId);
	
	public List<GradingFormat> readAllGradingFormats();
}
