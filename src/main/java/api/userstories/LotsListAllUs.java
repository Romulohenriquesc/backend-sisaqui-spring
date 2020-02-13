package api.userstories;

import org.springframework.stereotype.Service;

import api.domain.Lot;
import api.repository.LotRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
@Service
public class LotsListAllUs {
	private final LotRepository repository;
	
	public Flux<Lot> execute (){
		return repository.findAll();
	}
}
