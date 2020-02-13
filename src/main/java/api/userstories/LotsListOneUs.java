package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Lot;
import api.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class LotsListOneUs {
private final LotRepository repository;
	
	public Mono<Lot> execute (final String id){
		return repository.findById(id);
	}
}
