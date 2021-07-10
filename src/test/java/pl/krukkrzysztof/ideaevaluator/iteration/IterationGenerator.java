package pl.krukkrzysztof.ideaevaluator.iteration;

import com.github.javafaker.Faker;
import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;

import java.time.LocalDate;
import java.util.List;

import static pl.krukkrzysztof.ideaevaluator.commons.IdeaGenerator.generateRandomIdea;
import static pl.krukkrzysztof.ideaevaluator.result.ResultGenerator.generateRandomResult;

public class IterationGenerator {

    private static final Faker faker = new Faker();

    public static Iteration generateRandomIteration(){
        return Iteration.builder()
                .id(faker.number().randomNumber())
                .idea(generateRandomIdea())
                .visitsTotal(faker.number().numberBetween(0,3))
                .startDate(LocalDate.now())
                .endDate(LocalDate.now())
                .results(List.of(
                        generateRandomResult(),
                        generateRandomResult()
                ))
                .build();
    }
}
