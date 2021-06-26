package pl.krukkrzysztof.ideaevaluator.result.models.entities; 

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;

@Entity
@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Result { 

	@Id
	@GeneratedValue
	private Long id;
	private String path;
	private Integer clicks;
	@ManyToOne
	private Iteration iteration;
}