package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Nursery;
import api.repository.NurseryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class NurseriesListAllUs {
	private final NurseryRepository repository;
	
	public Flux<Nursery> execute (){
		return repository.findAll();
	}
}
