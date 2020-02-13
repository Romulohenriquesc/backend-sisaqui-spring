package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Ration;
import api.repository.RationRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class RationsListAllUs {
private final RationRepository repository;
	
	public Flux<Ration> execute (){
		return repository.findAll();
	}
}
