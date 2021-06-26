package pl.krukkrzysztof.ideaevaluator.result.models.dtos; 

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto { 

    private Long id;
    private String path;
    private String buttonName;
    private Integer clicks;
    private Long iteration;
}