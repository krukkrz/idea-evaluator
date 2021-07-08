package pl.krukkrzysztof.ideaevaluator.iteration.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.krukkrzysztof.ideaevaluator.iteration.models.entities.Iteration;
import pl.krukkrzysztof.ideaevaluator.iteration.repositories.IterationRepository;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IterationServiceTest {

    @Mock
    private IterationRepository repository;
    private IterationService service;

    @BeforeEach
    public void setup() {
        service = new IterationService(
                repository
        );
    }

    @Test
    public void updateVisits_updatesNumberOfVisitsForGivenIteration() {
        //GIVEN
        var id = 1L;
        var visits = 2;
        var iteration = Iteration.builder()
                .id(id)
                .visitsTotal(1)
                .build();

        when(repository.findById(id)).thenReturn(Optional.of(iteration));

        //WHEN
        service.updateVisits(id, visits);

        //THEN
        iteration.setVisitsTotal(3);
        verify(repository).save(iteration);
    }

}