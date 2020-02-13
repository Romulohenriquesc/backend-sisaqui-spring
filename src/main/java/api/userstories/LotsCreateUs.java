package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Lot;
import api.dto.in.LotsCreateInDto;
import api.service.LotsService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class LotsCreateUs {
	private final LotsService service;
	
	public final Mono<Lot> execute(final LotsCreateInDto lotsCreateInDto){
		return service
				.save(lotsCreateInDto.toLot());
	}
}
