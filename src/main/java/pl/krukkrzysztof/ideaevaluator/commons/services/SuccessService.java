package pl.krukkrzysztof.ideaevaluator.commons.services;

import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SuccessService {

    public static BigDecimal calculateSuccessRate(Iteration iteration) {
        var clicks = BigDecimal.valueOf(iteration.getResults().stream().mapToInt(Result::getClicks).sum());
        var visits = BigDecimal.valueOf(iteration.getVisitsTotal());
        return clicks.divide(visits, 2, RoundingMode.FLOOR).multiply(BigDecimal.valueOf(100)).setScale(0);
    }
}
