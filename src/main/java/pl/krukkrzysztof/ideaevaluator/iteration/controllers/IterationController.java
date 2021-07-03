package pl.krukkrzysztof.ideaevaluator.iteration.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.krukkrzysztof.ideaevaluator.iteration.models.dtos.IterationDto;
import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;
import pl.krukkrzysztof.ideaevaluator.iteration.models.mapping.IterationMapper;
import pl.krukkrzysztof.ideaevaluator.iteration.services.IterationService;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.OK;
import static pl.krukkrzysztof.ideaevaluator.iteration.models.mapping.IterationMapper.toDto;
import static pl.krukkrzysztof.ideaevaluator.iteration.models.mapping.IterationMapper.toModel;

@RestController
@RequestMapping("/iterations")
@AllArgsConstructor
public class IterationController {

    private final IterationService service;

    @PostMapping()
    public ResponseEntity<IterationDto> create(@RequestBody IterationDto iterationDto) {
        Iteration iteration = toModel(iterationDto);
        Iteration savedIteration = service.create(iteration);
        return ResponseEntity.ok(toDto(savedIteration));
    }

    @GetMapping()
    public ResponseEntity<List<IterationDto>> getAll() {
        return ResponseEntity.ok(
                service.getAll()
                        .stream()
                        .map(IterationMapper::toDto)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<IterationDto> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                toDto(service.getById(id))
        );
    }

    @PutMapping()
    public ResponseEntity<IterationDto> edit(@RequestBody IterationDto iterationDto) {
        Iteration iteration = toModel(iterationDto);
        Iteration savedIteration = service.edit(iteration);
        return ResponseEntity.ok(toDto(savedIteration));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(OK)
    public void delete(@PathVariable("id") Long id) {
        service.delete(id);
    }
}