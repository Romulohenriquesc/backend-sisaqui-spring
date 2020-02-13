package api.resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import api.dto.in.EventsCreateInDto;
import api.dto.out.EventsDefaultOutDto;
import api.userstories.EventsCreateUs;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
@RequestMapping("events")
public class EventsResource {
	private final EventsCreateUs eventsCreateUs;
	
	@PostMapping("{nurseryId}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<EventsDefaultOutDto> post(@PathVariable("nurseryId") final String nurseryId, @RequestBody final EventsCreateInDto createInDto){

		return eventsCreateUs
				.execute(nurseryId,createInDto)
				.map(EventsDefaultOutDto::fromEvent);
	}
	
}
