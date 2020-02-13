package api.service;

import org.springframework.stereotype.Service;

import api.domain.Lot;
import api.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class LotsService {
	private final LotRepository repository;
	
	public final Mono<Lot> save(final Lot lot){
		return repository.save(lot);
	}
	public final Mono<Void> delete(final String id){
		return repository.deleteById(id);
	}
	public final Mono<Lot> findById(final String id){
		return repository.findById(id);
	
	}
	
	public Flux<Lot> findByNurseryId(String nurseryId){
		return repository.findByNurseryId(nurseryId);
	}

}
