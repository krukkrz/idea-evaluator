package pl.krukkrzysztof.ideaevaluator.commons;

import com.github.javafaker.Faker;
import pl.krukkrzysztof.ideaevaluator.idea.models.entities.Idea;

public class IdeaGenerator {

    private static final Faker faker = new Faker();

    public static Idea generateRandomIdea(){
        return Idea.builder()
                .id(faker.number().randomNumber())
                .name(faker.lorem().paragraph())
                .description(faker.lorem().paragraph())
                .build();
    }

}
