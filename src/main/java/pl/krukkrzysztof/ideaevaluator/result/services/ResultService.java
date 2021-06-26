package pl.krukkrzysztof.ideaevaluator.result.services; 

import org.springframework.transaction.annotation.Transactional;
import pl.krukkrzysztof.ideaevaluator.result.repositories.ResultRepository;
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import javax.persistence.EntityNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class ResultService { 

	private final ResultRepository repository;

	@Transactional
	public Result create(Result result) {
		return repository.save(result);
	}

	public List<Result> getAll() {
		return (List<Result>) repository.findAll();
	}

	public Result getById(Long id) {
		return repository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Transactional
	public Result edit(Result result) {
		return repository.save(result);
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}