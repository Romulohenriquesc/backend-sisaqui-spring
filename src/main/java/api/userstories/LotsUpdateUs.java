package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Lot;
import api.dto.in.LotsUpdateInDto;
import api.service.LotsService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class LotsUpdateUs {
private final LotsService service;
	
	public final Mono<Lot> execute(String id, final LotsUpdateInDto lotsUpdateInDto){
		return service
				.findById(id)
				.map(lotsUpdateInDto::toLot)
				.flatMap(service::save);
	}
}
