package api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import api.domain.Ration;

public interface RationRepository extends ReactiveMongoRepository<Ration, String> {

}

