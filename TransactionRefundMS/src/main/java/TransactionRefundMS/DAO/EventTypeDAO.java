package TransactionRefundMS.DAO;

import java.util.List;

import TransactionRefundMS.pojos.EventType;

public interface EventTypeDAO {
	public EventType readEventType(int eventTypeId);
	
	public List<EventType> readAllEventTypes();
}
