package api.userstories;

import org.springframework.stereotype.Service;

import api.service.RationsService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class RationsDeleteUs {
	private final RationsService service;

	public final Mono<Void> execute(final String id) {
		return service.delete(id);
	}
}
