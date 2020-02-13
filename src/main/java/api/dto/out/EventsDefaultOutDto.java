package api.dto.out;

import java.time.LocalDateTime;

import api.domain.Event;
import api.domain.Event.Type;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EventsDefaultOutDto {
	private Object data;
	private LocalDateTime instant;
	private Type type;
	
	public static EventsDefaultOutDto fromEvent(final Event event) {
		return builder()
				.data(event.getData())
				.instant(event.getInstant())
				.type(event.getType())
				.build();
	}
}
