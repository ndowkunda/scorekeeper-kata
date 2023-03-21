package unit.domain.scorekeeper;

import domain.scorekeeper.ScoreKeeper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ScoreKeeperService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ScoreKeeperTest {
    private ScoreKeeper scoreKeeper;
    private ScoreKeeperService service;

    @BeforeEach
    public void setUp() {
        service = mock(ScoreKeeperService.class);
        scoreKeeper = new ScoreKeeper(service);

    }

    @Test
    void shouldReturnInitialScore() {
        when(service.getScore()).thenReturn("000:000");
        assertEquals("000:000", scoreKeeper.getScore());
    }

    @Test
    void shouldIncrementTeamAScore() {
        when(service.getScore()).thenReturn("001:000");
        scoreKeeper.scoreTeamA1();
        assertEquals("001:000", scoreKeeper.getScore());
    }

    @Test
    void shouldIncrementTeamBScore() {
        when(service.getScore()).thenReturn("000:002");
        scoreKeeper.scoreTeamB2();
        assertEquals("000:002", scoreKeeper.getScore());
    }

    @Test
    void shouldIncrementBothTeamScores() {
        when(service.getScore()).thenReturn("003:003");
        scoreKeeper.scoreTeamA3();
        scoreKeeper.scoreTeamB3();
        assertEquals("003:003", scoreKeeper.getScore());
    }
}