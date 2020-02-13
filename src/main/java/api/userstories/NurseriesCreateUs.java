package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Nursery;
import api.dto.in.NurseriesCreateInDto;
import api.service.NurseriesService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class NurseriesCreateUs {

	private final NurseriesService service;
	
	public final Mono<Nursery> execute(final NurseriesCreateInDto nurseriesCreateInDto){
		return service
				.save(nurseriesCreateInDto.toNursery());
	}
}
