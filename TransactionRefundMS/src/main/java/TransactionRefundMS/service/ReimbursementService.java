package TransactionRefundMS.service;
import java.util.List;

import TransactionRefundMS.pojos.Event;

import TransactionRefundMS.pojos.Grade;
import TransactionRefundMS.pojos.GradingFormat;
import TransactionRefundMS.pojos.Reimbursement;
import TransactionRefundMS.pojos.ReimbursementStatus;


public interface ReimbursementService {
	
	public List<Event> eventsReportsTo(int employeeId);

	public Reimbursement createReimbursement(Reimbursement reimbursement);
	
	public Reimbursement readReimbursement(int reimbursementId);
	
	public void updateCost(int reimbursementid, double cost);
	
	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId);
	
	public List<Reimbursement> readReimbursementById(int employee_id); //add
	
	public List<Reimbursement> readReimbursementByReportTo(int reportsTo);
	
	public int updateReimbursementDirSupDate(int reimbursementId, Reimbursement reimbursement);
	
	public int creatEvent(Event event);
	
	public Event readEvent(int eventId);
	
	public List<Event> readEventById(int employee_id); //add
	
	public Event updateEvent(int eventId, Event event);
	
	//public EventType readEventType(int eventTypeId);
	
	//public GradingFormat readGradingFormat(int gradingFormatId);	
	
	public Grade readGrade(int gradeId);

	public void updateNote(int reimbursementId, String note, int employeeId);

	public List<Reimbursement> readAllReimbursements();

	public void employeeGrade(int eventId, String grade);

	public List<Event> readAllEvents();

	public void superGrade(int eventId, int grade);

	public void updateStatus(int reimbursementId, int status);
}
