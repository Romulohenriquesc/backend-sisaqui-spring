package api.service;

import org.springframework.stereotype.Service;

import api.domain.Nursery;
import api.repository.NurseryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class NurseriesService {

	private final NurseryRepository repository;

	public final Mono<Nursery> save(final Nursery nursery){
			return repository.save(nursery);
	}
	public final Mono<Void> delete(final String id){
		return repository.deleteById(id);
	}
	
	public final Mono<Nursery> findById(final String id){
		return repository.findById(id);
	
	}
	
}
