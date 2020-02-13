package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Nursery;
import api.repository.NurseryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class NurseriesDetailsUs {
	private final NurseryRepository repository;
	
	public Mono<Nursery> execute (final String id){
		return repository.findById(id);
	}
}
