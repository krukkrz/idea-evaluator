package pl.krukkrzysztof.ideaevaluator.result;

import com.github.javafaker.Faker;
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;

public class ResultGenerator {

    private static final Faker faker = new Faker();

    public static Result generateRandomResult(){
        return Result.builder()
                .id(faker.number().randomNumber())
                .clicks(faker.number().numberBetween(0,5))
                .buttonName(faker.numerify("button-#"))
                .path(faker.numerify("/path-#"))
                .build();
    }

}
