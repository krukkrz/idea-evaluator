package pl.krukkrzysztof.ideaevaluator.idea.models.dtos; 

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import pl.krukkrzysztof.ideaevaluator.iteration.models.dtos.IterationDto;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdeaDto {

    private Long id;
    private String notes;
    private String description;
    private List<IterationDto> iterations;
}