package api.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class Event {

	private Object data;
	private LocalDateTime instant;
	
	private Type type;
	
	public static Event newEvent() {
		return new Event().setInstant(LocalDateTime.now());
	}
	public enum Type {
		ALIMENT,SENSING
	}
}
