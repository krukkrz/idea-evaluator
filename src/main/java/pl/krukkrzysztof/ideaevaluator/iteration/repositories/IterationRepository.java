package pl.krukkrzysztof.ideaevaluator.iteration.repositories; 

import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface IterationRepository extends CrudRepository<Iteration, Long> { 

}