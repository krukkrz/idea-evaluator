package pl.krukkrzysztof.ideaevaluator.result.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.krukkrzysztof.ideaevaluator.result.models.entities.Result;
import pl.krukkrzysztof.ideaevaluator.result.repositories.ResultRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ResultServiceTest {

    @Mock
    private ResultRepository repository;

    private ResultService service;

    @BeforeEach
    public void setup() {
        service = new ResultService(repository);
    }

    @Test
    public void edit_shouldOnlyEditIfIdExistsInDb() {
        //GIVEN
        var id = 2L;
        Result editedResult = Result.builder()
                .id(id)
                .clicks(0)
                .build();

        when(repository.findById(id)).thenReturn(Optional.empty());

        //WHEN //THEN
        assertThrows(EntityNotFoundException.class, () -> service.edit(editedResult));
    }
}