package pl.krukkrzysztof.ideaevaluator.idea.repositories; 

import pl.krukkrzysztof.ideaevaluator.idea.models.entities.Idea;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface IdeaRepository extends CrudRepository<Idea, Long> { 

}