package pl.krukkrzysztof.ideaevaluator.idea.controllers; 

import pl.krukkrzysztof.ideaevaluator.idea.services.IdeaService;
import pl.krukkrzysztof.ideaevaluator.idea.models.dtos.IdeaDto;
import pl.krukkrzysztof.ideaevaluator.idea.models.entities.Idea;
import pl.krukkrzysztof.ideaevaluator.idea.models.mapping.IdeaMapper;
import static pl.krukkrzysztof.ideaevaluator.idea.models.mapping.IdeaMapper.toDto;
import static pl.krukkrzysztof.ideaevaluator.idea.models.mapping.IdeaMapper.toModel;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PathVariable;
import static org.springframework.http.HttpStatus.OK;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ideas")
@AllArgsConstructor
public class IdeaController { 

	private final IdeaService service;

	@PostMapping()
	public ResponseEntity<IdeaDto> create(@RequestBody IdeaDto ideaDto) {
		Idea idea = toModel(ideaDto);
		Idea savedIdea = service.create(idea);
		return ResponseEntity.ok(toDto(savedIdea));
	}

	@GetMapping()
	public ResponseEntity<List<IdeaDto>> getAll() {
		return ResponseEntity.ok(
			service.getAll()
				.stream()
				.map(IdeaMapper::toDto)
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<IdeaDto> getById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(
			toDto(service.getById(id))
		);
	}

	@PutMapping()
	public ResponseEntity<IdeaDto> edit(@RequestBody IdeaDto ideaDto) {
		Idea idea = toModel(ideaDto);
		Idea savedIdea = service.edit(idea);
		return ResponseEntity.ok(toDto(savedIdea));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public void delete(@PathVariable("id")Long id) {
		service.delete(id);
	}
}