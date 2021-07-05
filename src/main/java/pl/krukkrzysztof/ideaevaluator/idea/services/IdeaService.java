package pl.krukkrzysztof.ideaevaluator.idea.services; 

import org.springframework.transaction.annotation.Transactional;
import pl.krukkrzysztof.ideaevaluator.idea.repositories.IdeaRepository;
import pl.krukkrzysztof.ideaevaluator.idea.models.entities.Idea;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import javax.persistence.EntityNotFoundException;

import java.util.List;

@Service
@AllArgsConstructor
public class IdeaService { 

	private final IdeaRepository repository;

	@Transactional
	public Idea create(Idea idea) {
		return repository.save(idea);
	}

	public List<Idea> getAll() {
		return (List<Idea>) repository.findAll();
	}

	public Idea getById(Long id) {
		return repository.findById(id).orElseThrow(EntityNotFoundException::new);
	}

	@Transactional
	public Idea edit(Idea idea) {
		return repository.save(idea);
	}

	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
}