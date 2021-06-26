package pl.krukkrzysztof.ideaevaluator.result.controllers; 

import pl.krukkrzysztof.ideaevaluator.result.services.ResultService;
import pl.krukkrzysztof.ideaevaluator.result.models.dtos.ResultDto;
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;
import pl.krukkrzysztof.ideaevaluator.result.models.mapping.ResultMapper;
import static pl.krukkrzysztof.ideaevaluator.result.models.mapping.ResultMapper.toDto;
import static pl.krukkrzysztof.ideaevaluator.result.models.mapping.ResultMapper.toModel;

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
@RequestMapping("/results")
@AllArgsConstructor
public class ResultController { 

	private final ResultService service;

	@PostMapping()
	public ResponseEntity<ResultDto> create(@RequestBody ResultDto resultDto) {
		Result result = toModel(resultDto);
		Result savedResult = service.create(result);
		return ResponseEntity.ok(toDto(savedResult));
	}

	@GetMapping()
	public ResponseEntity<List<ResultDto>> getAll() {
		return ResponseEntity.ok(
			service.getAll()
				.stream()
				.map(ResultMapper::toDto)
				.collect(Collectors.toList()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResultDto> getById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(
			toDto(service.getById(id))
		);
	}

	@PutMapping()
	public ResponseEntity<ResultDto> edit(@RequestBody ResultDto resultDto) {
		Result result = toModel(resultDto);
		Result savedResult = service.edit(result);
		return ResponseEntity.ok(toDto(savedResult));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public void delete(@PathVariable("id")Long id) {
		service.delete(id);
	}
}