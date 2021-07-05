package pl.krukkrzysztof.ideaevaluator.iteration.models.mapping; 

import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;
import pl.krukkrzysztof.ideaevaluator.iteration.models.dtos.IterationDto;

import org.springframework.stereotype.Component;
import pl.krukkrzysztof.ideaevaluator.result.models.dtos.ResultDto;
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;
import pl.krukkrzysztof.ideaevaluator.result.models.mapping.ResultMapper;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class IterationMapper { 
	public static Iteration toModel(IterationDto iteration) {
		return Iteration.builder()
				.id(iteration.getId())
				.domain(iteration.getDomain())
				.startDate(iteration.getStartDate())
				.endDate(iteration.getEndDate())
				.visitsTotal(iteration.getVisitsTotal())
				.results(mapResultDtoListToModels(iteration))
				.build();
	}

	public static IterationDto toDto(Iteration iteration) {
		return IterationDto.builder()
				.id(iteration.getId())
				.domain(iteration.getDomain())
				.startDate(iteration.getStartDate())
				.endDate(iteration.getEndDate())
				.visitsTotal(iteration.getVisitsTotal())
				.results(mapResultsToDtos(iteration))
				.build();
	}

	private static List<ResultDto> mapResultsToDtos(Iteration iteration) {
		return iteration.getResults().stream().map(ResultMapper::toDto).collect(Collectors.toList());
	}

	private static List<Result> mapResultDtoListToModels(IterationDto iteration) {
		return iteration.getResults().stream().map(ResultMapper::toModel).collect(Collectors.toList());
	}
}