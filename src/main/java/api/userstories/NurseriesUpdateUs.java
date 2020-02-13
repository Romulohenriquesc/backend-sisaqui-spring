package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Nursery;
import api.dto.in.NurseriesUpdateInDto;
import api.service.NurseriesService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class NurseriesUpdateUs {

	private final NurseriesService service;
	
	public final Mono<Nursery> execute(String id, final NurseriesUpdateInDto nurseriesUpdateInDto){
		return service
				.findById(id)
				.map(nurseriesUpdateInDto::toNursery)
				.flatMap(service::save);
	}
}
