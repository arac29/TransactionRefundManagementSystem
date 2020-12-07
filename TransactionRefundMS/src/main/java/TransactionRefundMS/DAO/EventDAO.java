package TransactionRefundMS.DAO;

import java.util.List;

import TransactionRefundMS.pojos.Event;

public interface EventDAO {
	public int createEvent(Event event);
	
	public Event readEvent(int eventId);
	
	public List<Event> readAllEvents();
	
	public List<Event> readEventById(int employee_id);
	
	//public int deleteEvent(int eventId);

	public int updateEvent(int eventId, Event event);

	public void employeeGrade(int eventId, String grade);

	public List<Event> eventsReportsTo(int employeeId);

	public void superGrade(int eventId, int grade);
}
