package pl.krukkrzysztof.ideaevaluator.idea.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.krukkrzysztof.ideaevaluator.iteration.models.dtos.IterationDto;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IdeaDto {

    private Long id;
    private String name;
    private String notes;
    private String description;
    private List<IterationDto> iterations;
}