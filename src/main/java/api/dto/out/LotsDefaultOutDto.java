package api.dto.out;

import java.util.List;

import api.domain.Event;
import api.domain.Lot;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LotsDefaultOutDto {
	private final String id;
	
	private final List<String> nurseries;
	private final String name;
	private final List<Event> events;
	
	public static LotsDefaultOutDto fromLot(final Lot lot) {
		return builder()
				.id(lot.getId())
				.name(lot.getName())
				.nurseries(lot.getNurseries())
				.events(lot.getEvents())
				.build();
	}
}
