package api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import api.domain.Nursery;

public interface NurseryRepository  extends ReactiveMongoRepository<Nursery, String>{

}
