package pl.krukkrzysztof.ideaevaluator.iteration.models.dtos; 

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import pl.krukkrzysztof.ideaevaluator.result.models.dtos.ResultDto;
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;

import java.time.LocalDate;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IterationDto {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String domain;
    private Integer visitsTotal;
    private List<ResultDto> results;
    private Long idea;
}