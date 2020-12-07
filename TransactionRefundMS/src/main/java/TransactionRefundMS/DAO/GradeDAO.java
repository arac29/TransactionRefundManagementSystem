package TransactionRefundMS.DAO;

import java.util.List;

import TransactionRefundMS.pojos.Grade;

public interface GradeDAO {
	public Grade readGrade(int gradeId);
	
	public List<Grade> readAllGrades();
	
}
