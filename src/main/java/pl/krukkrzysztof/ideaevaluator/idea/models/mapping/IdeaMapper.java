package pl.krukkrzysztof.ideaevaluator.idea.models.mapping;

import org.springframework.stereotype.Component;
import pl.krukkrzysztof.ideaevaluator.idea.models.dtos.IdeaDto;
import pl.krukkrzysztof.ideaevaluator.idea.models.entities.Idea;
import pl.krukkrzysztof.ideaevaluator.iteration.models.dtos.IterationDto;
import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;

import java.util.List;
import java.util.stream.Collectors;

import static pl.krukkrzysztof.ideaevaluator.commons.services.SuccessService.calculateSuccessRate;

@Component
public class IdeaMapper {

    public static Idea toModel(IdeaDto idea) {
        return Idea.builder()
                .id(idea.getId())
				.name(idea.getName())
                .description(idea.getDescription())
                .notes(idea.getNotes())
				.iterations(mapIterationDtosToEntity(idea.getIterations()))
                .build();
    }

    public static IdeaDto toDto(Idea idea) {
        return IdeaDto.builder()
                .id(idea.getId())
				.name(idea.getName())
				.description(idea.getDescription())
                .notes(idea.getNotes())
				.iterations(mapIterationsToDtos(idea.getIterations()))
                .build();
    }

    public static List<IterationDto> mapIterationsToDtos(List<Iteration> iterations) {
        return iterations.stream().map(
                iteration -> IterationDto.builder()
                        .id(iteration.getId())
                        .startDate(iteration.getStartDate())
                        .endDate(iteration.getEndDate())
						.domain(iteration.getDomain())
						.successRate(calculateSuccessRate(iteration))
						.visitsTotal(iteration.getVisitsTotal())
                        .build()
        ).collect(Collectors.toList());
    }

	public static List<Iteration> mapIterationDtosToEntity(List<IterationDto> iterations) {
		return iterations.stream().map(
				iteration -> Iteration.builder()
						.id(iteration.getId())
						.startDate(iteration.getStartDate())
						.endDate(iteration.getEndDate())
						.domain(iteration.getDomain())
						.visitsTotal(iteration.getVisitsTotal())
						.build()
		).collect(Collectors.toList());
	}
}