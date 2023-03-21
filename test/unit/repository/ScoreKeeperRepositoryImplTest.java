package unit.repository;

import domain.scorekeeper.Points;
import domain.scorekeeper.ScoreFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ScoreKeeperRepository;
import repository.ScoreKeeperRepositoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScoreKeeperRepositoryImplTest {
    private ScoreKeeperRepository repository;
    private ScoreFormatter scoreFormatter;

    @BeforeEach
    public void setUp() {
        scoreFormatter = mock(ScoreFormatter.class);
        repository = new ScoreKeeperRepositoryImpl(scoreFormatter);

    }

    @Test
    public void shouldIncrementTeamAScore() {
        when(scoreFormatter.format(2, 0)).thenReturn("002:000");

        repository.incrementTeamAScore(Points.TWO_POINTS);
        String actualScore = repository.getScore();

        assertEquals("002:000", actualScore);
    }

    @Test
    public void shouldIncrementTeamBScore() {
        repository.incrementTeamBScore(Points.TWO_POINTS);

        when(scoreFormatter.format(0, 2)).thenReturn("000:002");

        String actualScore = repository.getScore();

        assertEquals("000:002", actualScore);
    }

    @Test
    public void shouldGetScoreForBothTeams() {
        repository.incrementTeamAScore(Points.THREE_POINTS);
        repository.incrementTeamBScore(Points.THREE_POINTS);

        when(scoreFormatter.format(3, 3)).thenReturn("003:003");

        String actualScore = repository.getScore();

        assertEquals("003:003", actualScore);
    }

}
