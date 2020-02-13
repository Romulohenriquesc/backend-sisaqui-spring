package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Ration;
import api.dto.in.RationsCreateInDto;
import api.service.RationsService;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class RationsCreateUs {
private final RationsService service;
	
	public final Mono<Ration> execute(final RationsCreateInDto rationsCreateInDto){
		return service
				.save(rationsCreateInDto.toRation());
	}
}
