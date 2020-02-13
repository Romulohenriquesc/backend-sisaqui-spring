package api.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Document
@Getter
@Setter
@Accessors(chain = true)
public class Lot {
	
	@Id
	private String id;
	private String name;
	
	private List<String> nurseries;
	
	private List<Event> events;
	
	public Lot() {
		events = new ArrayList<Event>();
	}
	public void addEvent(Event e){
		this.events.add(e);
	}
	
	public static Lot newLot() {
		
		return new Lot();
	}
}
