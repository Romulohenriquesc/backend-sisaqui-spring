package api.dto.in;

import java.util.Map;

import api.domain.Event;
import api.domain.Event.Type;
import lombok.Setter;

@Setter
public class EventsCreateInDto {
	
	private Map<String, Object> data;
	private Type type;
	
	public Event toEvent(){
		
		return Event
				.newEvent()
				.setData(data)
				.setType(type);
	}
	
	
}
