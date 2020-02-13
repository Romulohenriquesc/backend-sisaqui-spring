package api.service;

import org.springframework.stereotype.Service;

import api.domain.Ration;
import api.repository.RationRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class RationsService {
	private final RationRepository repository;
	
	public final Mono<Ration> save(final Ration ration){
		return repository.save(ration);
	}
	public final Mono<Void> delete(final String id){
		return repository.deleteById(id);
	}
}