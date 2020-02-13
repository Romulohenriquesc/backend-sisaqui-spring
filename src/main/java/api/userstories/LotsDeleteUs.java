package api.userstories;

import org.springframework.stereotype.Service;

import api.service.LotsService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class LotsDeleteUs {
	private final LotsService service;

	public final Mono<Void> execute(final String id) {
		return service.delete(id);
	}
}
