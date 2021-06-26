package pl.krukkrzysztof.ideaevaluator.result.models.mapping; 

import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;
import pl.krukkrzysztof.ideaevaluator.result.models.dtos.ResultDto;

import org.springframework.stereotype.Component;

@Component
public class ResultMapper {

	public static Result toModel(ResultDto result) {
		return Result.builder()
				.id(result.getId())
				.path(result.getPath())
				.buttonName(result.getButtonName())
				.clicks(result.getClicks())
				.iteration(
						Iteration.builder()
								.id(result.getIteration())
								.build()
				)
				.build();
	}

	public static ResultDto toDto(Result result) {
		return ResultDto.builder()
				.id(result.getId())
				.path(result.getPath())
				.buttonName(result.getButtonName())
				.clicks(result.getClicks())
				.iteration(result.getIteration().getId())
				.build();
	}
}