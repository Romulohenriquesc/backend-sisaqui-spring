package api.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import api.domain.Lot;
import reactor.core.publisher.Flux;

public interface LotRepository extends ReactiveMongoRepository<Lot, String>{
	
	@Query("{ nurseries: { $eq: ?0 } }")
	public Flux<Lot> findByNurseryId(String nurseryId);
}
