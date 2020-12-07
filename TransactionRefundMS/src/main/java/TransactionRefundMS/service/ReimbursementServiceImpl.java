package TransactionRefundMS.service;

import TransactionRefundMS.pojos.*;

import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.*;
import TransactionRefundMS.Postgres.*;


public class ReimbursementServiceImpl implements ReimbursementService{
	
	EmployeeDAO employeeDao = new EmployeeDAOPostgres();
	
	ReimbursementDAO reimbursementDao= new ReimbursementDAOPostgres();
	
	ReimbursementStatusDAO reimbursementStatusDao = new ReimbursementStatusDAOPostgres();
	
	EventDAO eventDao= new EventDAOPostgres();
	
	
	GradeDAO gradeDao= new GradeDAOPostgres();
	
	private static Logger log = Logger.getRootLogger();

	@Override
	public Reimbursement createReimbursement(Reimbursement reimbursement) {
		log.info("Service - Create Reimbursement");
		reimbursementDao.createReimbursement(reimbursement);
		return reimbursement;
	}

	@Override
	public Reimbursement readReimbursement(int reimbursementId) {
		log.info(" Service - Read Reimbursement by Id");
		return reimbursementDao.readReimbursement(reimbursementId);
	}

	@Override
	public ReimbursementStatus readReimbursementStatus(int reimbursementStatusId) {
		log.info("F Service -Read Reimbursement Status by Id");
		return reimbursementStatusDao.readReimbursementStatus(reimbursementStatusId);
	}
	
	@Override
	public List<Reimbursement> readReimbursementById(int employee_id) {
		log.info(" Service -Read Reimbursement Status by employee");
		return reimbursementDao.readReimbursementById(employee_id);
	}
	@Override
	public List<Reimbursement> readAllReimbursements() {
		log.info(" Service -Read Reimbursement Status by employee");
		return reimbursementDao.readAllReimbursements();
	}
	@Override
	public int creatEvent(Event event) {
		log.info(" Service - Create Event");
		
		return eventDao.createEvent(event);
	}

	@Override
	public Event readEvent(int eventId) {
		log.info("ervice -Read Event by Id");
		return eventDao.readEvent(eventId);
	}

	@Override
	public Event updateEvent(int eventId, Event event) {
		log.info("Service -- Update Event by Id");
		eventDao.updateEvent(eventId, event);
		return event;
	}

	@Override
	public Grade readGrade(int gradeId) {
		log.info("Service --Read Grade by Id");
		return gradeDao.readGrade(gradeId);
	}

	@Override
	public List<Event> readEventById(int employee_id) {
		log.info(" Service -Read Events by employee");
		return eventDao.readEventById(employee_id);
	}
	@Override
	public List<Reimbursement> readReimbursementByReportTo(int reportsTo) {
		log.info("Form Service --> read reimbursement by reports to");
		return reimbursementDao.readAllReimbsByReportTo(reportsTo);
	}
	@Override
	public int updateReimbursementDirSupDate(int reimbursementId, Reimbursement reimbursement) {
		log.info("Form Service --> updateReimbursementDirSupDate");
		return reimbursementDao.updateReimbursementDirSupDate(reimbursementId, reimbursement);
	}

	@Override
	public void updateCost(int reimbursementid, double cost) {
		log.info("Form Service --> updateReimbursementDirSupDate");
		reimbursementDao.updateCost(reimbursementid, cost);
		
	}

	@Override
	public void updateNote(int reimbursementId, String note, int employeeId) {
		log.info("Form Service --> updateNote");
		reimbursementDao.updateNote(reimbursementId, note,employeeId);
		
	}

	@Override
	public void employeeGrade(int eventId, String grade) {
		log.info(" Serviive submit grade  by employee");
		eventDao.employeeGrade(eventId,grade);		
	}

	@Override
	public List<Event> readAllEvents() {
		log.info(" Service -Read Events ");
		return eventDao.readAllEvents();
	}

	@Override
	public List<Event> eventsReportsTo(int employeeId) {
		log.info(" Service -Read Events by reports to");
		return eventDao.eventsReportsTo(employeeId);
	
	}

	@Override
	public void superGrade(int eventId, int grade) {
		log.info(" Serviive submit grade final");
		eventDao.superGrade(eventId,grade);		
		
	}

	@Override
	public void updateStatus(int reimbursementId, int status) {
		log.info("service - update reimbursement status");
		reimbursementDao.updateStatus(reimbursementId, status);
		
	}

}
