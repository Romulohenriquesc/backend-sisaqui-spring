package api.userstories;

import org.springframework.stereotype.Service;

import api.service.NurseriesService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class NurseriesDeleteUs {
	private final NurseriesService service;

	public final Mono<Void> execute(final String id) {
		return service.delete(id);
	}
}
