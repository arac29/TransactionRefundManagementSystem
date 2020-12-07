package TransactionRefundMS.Postgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.GradingFormatDAO;
import TransactionRefundMS.pojos.GradingFormat;
import TransactionRefundMS.util.ConnectionUtil;
public class GradingFormatPostgres implements GradingFormatDAO{

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	@Override
	public GradingFormat readGradingFormat(int gradingFormatId) {
		String sql = "select * from grading_format_company where grading_format_id = " + gradingFormatId;

		GradingFormat gradingFormatCompany = new GradingFormat();

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read grading format company by id = " + gradingFormatId);

			while (rs.next()) {

				gradingFormatId = rs.getInt("grading_format_id");
				String gradingFormat = rs.getString("grading_format");

				gradingFormatCompany.setGradingFormatId(gradingFormatId);
				gradingFormatCompany.setGradingFormat(gradingFormat);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gradingFormatCompany;
	}

	@Override
	public List<GradingFormat> readAllGradingFormats() {
		// TODO Auto-generated method stub
		return null;
	}

}
