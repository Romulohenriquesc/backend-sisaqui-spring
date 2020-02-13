package api.dto.out;

import java.util.List;

import api.domain.Event;
import api.domain.Nursery;
import api.domain.Nursery.Type;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NurseriesDefaultOutDto {
	private final String id;
	private final String name;
	private final Type type;
	private final List<Event> events;
	
	
	public static NurseriesDefaultOutDto fromNursery(final Nursery nursery) {
		return builder()
				.id(nursery.getId())
				.name(nursery.getName())
				.type(nursery.getType())
				.events(nursery.getEvents())
				.build();
	}
}
