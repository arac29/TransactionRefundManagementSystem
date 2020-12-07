package TransactionRefundMS.Postgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.GradeDAO;
import TransactionRefundMS.pojos.Grade;
import TransactionRefundMS.util.ConnectionUtil;
public class GradeDAOPostgres implements GradeDAO
{

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	@Override
	public Grade readGrade(int gradeId) {
		String sql = "select * from grade where grade_id = " + gradeId;

		Grade grade = new Grade();

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read grade by id = " + gradeId);

			while (rs.next()) {

				gradeId = rs.getInt("grade_id");
				String gradeLetter = rs.getString("grade_letter");
				double minPercentage = rs.getDouble("min_percentage");
				double maxPercentage = rs.getDouble("max_percentage");
				String passFail = rs.getString("pass_fail");

				grade.setGradeId(gradeId);
				grade.setGradeLetter(gradeLetter);
				grade.setMinPercentage(minPercentage);
				grade.setMaxPercentage(maxPercentage);
				grade.setPassFail(passFail);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return grade;
		
	}

	@Override
	public List<Grade> readAllGrades() {
		// TODO Auto-generated method stub
		return null;
	}

}
