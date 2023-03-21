package unit.service;

import domain.scorekeeper.Points;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ScoreKeeperRepository;
import service.ScoreKeeperService;
import service.ScoreKeeperServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ScoreKeeperServiceImplTest {
    private ScoreKeeperRepository repository;
    private ScoreKeeperService service;

    @BeforeEach
    public void setUp() {
        repository = mock(ScoreKeeperRepository.class);
        service = new ScoreKeeperServiceImpl(repository);
    }

    @Test
    public void incrementTeamAScore() {
        service.incrementTeamAScore(Points.ONE_POINT);
        verify(repository).incrementTeamAScore(Points.ONE_POINT);
    }

    @Test
    public void incrementTeamBScore() {
        service.incrementTeamBScore(Points.ONE_POINT);
        verify(repository).incrementTeamBScore(Points.ONE_POINT);
    }

    @Test
    public void getScore() {
        String expectedScore = "000:000";
        when(repository.getScore()).thenReturn(expectedScore);
        String actualScore = service.getScore();
        assertEquals(expectedScore, actualScore);
    }
}
