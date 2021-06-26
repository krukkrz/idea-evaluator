package pl.krukkrzysztof.ideaevaluator.iteration.models.entities; 

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
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;

import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Iteration { 

	@Id
	@GeneratedValue
	private Long id;
	private LocalDate startDate;
	private LocalDate endDate;
	private String domain;
	private String notes;
	private String idea;
	private Integer visitsTotal;
	@OneToMany(mappedBy = "iteration", cascade = CascadeType.ALL)
	private List<Result> results;
}