package pl.krukkrzysztof.ideaevaluator.iteration.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;
import pl.krukkrzysztof.ideaevaluator.iteration.repositories.IterationRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
public class IterationService {

    private final IterationRepository repository;

    @Transactional
    public Iteration create(Iteration iteration) {
        return repository.save(iteration);
    }

    public List<Iteration> getAll() {
        return (List<Iteration>) repository.findAll();
    }

    public Iteration getById(Long id) {
        return repository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public Iteration edit(Iteration iteration) {
        return repository.save(iteration);
    }

    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void updateVisits(long id, int visits) {
        Iteration iteration = getById(id);
        iteration.setVisitsTotal(iteration.getVisitsTotal() + visits);
        repository.save(iteration);
    }
}