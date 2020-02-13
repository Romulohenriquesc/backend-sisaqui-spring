package api.resource;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.domain.Event;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

@RestController
@RequestMapping("events")
public class EventsSharedResource {
	private final Flux<Event> flux;
	private FluxSink<Event> sse;
	

	public EventsSharedResource() {
		flux = Flux.<Event>create(emitter -> sse = emitter, FluxSink.OverflowStrategy.IGNORE).publish().autoConnect();
	}
	
	@GetMapping("mqtt")
	public void teste() {
		 
		if(sse != null) {
			sse.next(Event.newEvent());
		}
	}
	
	@GetMapping(path = "{id}/sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Event> streamFlux(){
		
		return flux;
	}
}
