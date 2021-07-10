package pl.krukkrzysztof.ideaevaluator.commons.services;

import org.junit.jupiter.api.Test;
import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.krukkrzysztof.ideaevaluator.commons.services.SuccessService.calculateSuccessRate;
import static pl.krukkrzysztof.ideaevaluator.iteration.IterationGenerator.generateRandomIteration;
import static pl.krukkrzysztof.ideaevaluator.result.ResultGenerator.generateRandomResult;

class SuccessServiceTest {

    @Test
    public void calculate_calculatesSuccessRateForGivenIteration() {
        //GIVEN
        Result result = generateRandomResult();
        result.setClicks(3);

        Iteration iteration = generateRandomIteration();
        iteration.setVisitsTotal(3);
        iteration.setResults(List.of(result));

        //WHEN
        BigDecimal actual = calculateSuccessRate(iteration);

        //THEN
        assertThat(actual).isEqualTo(BigDecimal.valueOf(100));
    }

    @Test
    public void calculate_calculatesSuccessRateForClicksLessThanVisits() {
        //GIVEN
        Result result = generateRandomResult();
        result.setClicks(2);

        Iteration iteration = generateRandomIteration();
        iteration.setVisitsTotal(3);
        iteration.setResults(List.of(result));

        //WHEN
        BigDecimal actual = calculateSuccessRate(iteration);

        //THEN
        assertThat(actual).isEqualTo(BigDecimal.valueOf(66));
    }

    @Test
    public void calculate_returnsZeroIfNoClicks() {
        //GIVEN
        Result result = generateRandomResult();
        result.setClicks(0);

        Iteration iteration = generateRandomIteration();
        iteration.setVisitsTotal(3);
        iteration.setResults(List.of(result));

        //WHEN
        BigDecimal actual = calculateSuccessRate(iteration);

        //THEN
        assertThat(actual).isEqualTo(BigDecimal.valueOf(0));
    }
}