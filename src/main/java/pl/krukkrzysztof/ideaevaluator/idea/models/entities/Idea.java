package pl.krukkrzysztof.ideaevaluator.idea.models.entities; 

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;

import java.util.List;

@Entity
@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Idea { 

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String notes;
	private String description;
	@OneToMany(mappedBy = "idea", cascade = CascadeType.ALL)
	private List<Iteration> iterations;
}