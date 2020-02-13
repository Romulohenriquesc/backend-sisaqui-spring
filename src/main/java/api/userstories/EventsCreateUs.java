package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Event;
import api.dto.in.EventsCreateInDto;
import api.service.LotsService;
import api.service.NurseriesService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class EventsCreateUs {
	private final NurseriesService nurseriesService;
	private final LotsService lotsService;
	
	public final Mono<Event> execute(final String nurseryId, final EventsCreateInDto eventsCreateInDto) {
		
		Event event = eventsCreateInDto.toEvent();
		
		return nurseriesService
		.findById(nurseryId)
		.map(n -> {
			n.addEvent(event);
			return n;
		})
		.flatMap(nurseriesService::save)
		.map(n ->{
			lotsService
				.findByNurseryId(n.getId())
				.map(lot -> {
					lot.addEvent(event);
					return lot;
				})
				.flatMap(lotsService::save)
				.subscribe();
			return event;
		});
		

	}
}
