package TransactionRefundMS.Postgres;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.EventDAO;
import TransactionRefundMS.pojos.Event;
import TransactionRefundMS.util.ConnectionUtil;

public class EventDAOPostgres implements EventDAO{
	
	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	
	@Override
	public int createEvent(Event event) {
		
		String sql = "insert into event (event_type_id, name, description, start_date, end_date, location,"
				+ " grading_format_id)" + "values(?, ?, ?, ?, ?, ?, ?);";

		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, event.getEventTypeId());
			stmt.setString(2, event.getName());
			stmt.setString(3, event.getDescription());
			stmt.setString(4, event.getStartDate());
			stmt.setString(5,event.getEndDate());
			stmt.setString(6, event.getLocation());
			stmt.setInt(7, event.getGradingFormatId());
			stmt.executeUpdate();

			log.info("Controller creating event");

		} catch (SQLException e) {
			e.printStackTrace();
			log.info("error  dao posgres event");
		}
		
		String sqli = "select * from event where name = '" + event.getName() + "';";
		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sqli);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				int eventId = rs.getInt("event_id");

				event.setEventId(eventId);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event.getEventId();

	}

	@Override
	public Event readEvent(int eventId) {
		String sql = "select * from event where event_id = " + eventId;

		Event event = new Event();

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read event by id = " + eventId);

			while (rs.next()) {

				eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String location = rs.getString("location");
				String employeeGrade=rs.getString("employee_grade");
				int gradingFormatId = rs.getInt("grading_format_id");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setLocation(location);
				event.setGradingFormatId(gradingFormatId);
				event.setGradeId(gradeId);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return event;
	}

	@Override
	public List<Event> readAllEvents() {
		List<Event> eventList = new ArrayList();

		String sql = "select * from event";

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read all event types");

			while (rs.next()) {

				Event event = new Event();

				int eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String location = rs.getString("location");
				int gradingFormatId = rs.getInt("grading_format_id");
				String employeeGrade = rs.getString("employee_grade");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setLocation(location);
				event.setGradingFormatId(gradingFormatId);
				event.setEmployeeGrade(employeeGrade);
				event.setGradeId(gradeId);

				eventList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public List<Event> readEventById(int employee_id) {
		List<Event> eventList = new ArrayList();

		String sql = "select r.employee_id, e.event_id, e.event_type_id, e.\"name\", e.description, e.start_date, e.end_date, e.\"location\", e.grading_format_id, e.grade_id ,e.employee_grade "
				+ "from reimbursement r "
				+ "join \"event\" e "
				+ "on r.event_id = e.event_id "
				+ "where employee_id = ?;";


		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,employee_id);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read all events by employee");

			while (rs.next()) {

				Event event = new Event();

				int eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String location = rs.getString("location");
				String employeeGrade=rs.getString("employee_grade");
				int gradingFormatId = rs.getInt("grading_format_id");
				int gradeId = rs.getInt("grade_id");

				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setLocation(location);
				event.setEmployeeGrade(employeeGrade);
				event.setGradingFormatId(gradingFormatId);
				event.setGradeId(gradeId);

				eventList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public int updateEvent(int eventId, Event event) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void employeeGrade(int eventId, String grade) {
		String sql="update event set employee_grade=? where event_id=? ;";
		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setString(1, grade);
			stmt.setInt(2, eventId);
			

			stmt.executeUpdate();

			log.info("Reimbursementid dao submit grade   = " );

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

	@Override
	public List<Event> eventsReportsTo(int employeeId) {
		List<Event> eventList = new ArrayList();
		String sql = "select e.event_id, e.event_type_id, e.\"name\", e.description, e.start_date, e.end_date, e.\"location\", "
					+ "e.grading_format_id, e.employee_grade, e.grade_id "
					+ "from \"event\" e " 
					+ "join reimbursement r " 
					+ "on e.event_id = r.event_id " 
					+ "join employee em "
					+ "on r.employee_id = em.employee_id " 
					+ "where em.reports_to = ?;";
		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, employeeId);
			ResultSet rs = stmt.executeQuery();
			log.info("Controller read all events by employee");
			while (rs.next()) {
				Event event = new Event();
				int eventId = rs.getInt("event_id");
				int eventTypeId = rs.getInt("event_type_id");
				String name = rs.getString("name");
				String description = rs.getString("description");
				String startDate = rs.getString("start_date");
				String endDate = rs.getString("end_date");
				String location = rs.getString("location");
				int gradingFormatId = rs.getInt("grading_format_id");
				String employeeGrade = rs.getString("employee_grade");
				int gradeId = rs.getInt("grade_id");
				event.setEventId(eventId);
				event.setEventTypeId(eventTypeId);
				event.setName(name);
				event.setDescription(description);
				event.setStartDate(startDate);
				event.setEndDate(endDate);
				event.setLocation(location);
				event.setGradingFormatId(gradingFormatId);
				event.setEmployeeGrade(employeeGrade);
				event.setGradeId(gradeId);
				eventList.add(event);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public void superGrade(int eventId, int grade) {
		String sql="update event set grade_id=? where event_id=? ;";
		try (Connection conn = connUtil.createConnection()) {
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1, grade);
			stmt.setInt(2, eventId);

			stmt.executeUpdate();

			log.info("event dao submit grade final  = " );

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
