package pl.krukkrzysztof.ideaevaluator.result.repositories; 

import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ResultRepository extends CrudRepository<Result, Long> { 

}