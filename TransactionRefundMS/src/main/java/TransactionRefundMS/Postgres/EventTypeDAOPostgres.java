package TransactionRefundMS.Postgres;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import TransactionRefundMS.DAO.EventTypeDAO;
import TransactionRefundMS.pojos.EventType;
import TransactionRefundMS.util.ConnectionUtil;
public class EventTypeDAOPostgres implements EventTypeDAO{

	private static Logger log = Logger.getRootLogger();

	private PreparedStatement prepSt;
	
	private PreparedStatement stmt;
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	@Override
	public EventType readEventType(int eventTypeId) {
		String sql = "select * from event_type where event_type_id = " + eventTypeId;

		EventType eventType = new EventType();

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();

			log.info("Controller read event by id = " + eventTypeId);

			while (rs.next()) {

				eventTypeId = rs.getInt("event_type_id");
				String eventTypesName = rs.getString("event_type_names");
				double eventTypePercentage = rs.getDouble("event_type_percentage");

				eventType.setEventTypeId(eventTypeId);
				eventType.setEventTypesName(eventTypesName);
				eventType.setEventTypePercentage(eventTypePercentage);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventType;
	}

	@Override
	public List<EventType> readAllEventTypes() {
		List<EventType> eventTypeList = new ArrayList();

		String sql = "select * from event_type";

		try (Connection conn = connUtil.createConnection()) {

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			
			log.info("Controller read all events");

			while (rs.next()) {

				EventType eventType = new EventType();
				
				int eventTypeId = rs.getInt("event_type_id");
				String eventTypesName = rs.getString("event_type_names");
				double eventTypePercentage = rs.getDouble("event_type_percentage");

				eventType.setEventTypeId(eventTypeId);
				eventType.setEventTypesName(eventTypesName);
				eventType.setEventTypePercentage(eventTypePercentage);
				
				
				eventTypeList.add(eventType);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return eventTypeList;
	}
	
}
