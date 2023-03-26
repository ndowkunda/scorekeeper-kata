package unit.service;

import domain.scorekeeper.Points;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenter.ScoreFormatterImpl;
import repository.ScoreKeeperRepositoryImpl;
import service.ScoreKeeperServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ScoreKeeperServiceImplTest {
    private ScoreFormatterImpl formatter;
    private ScoreKeeperRepositoryImpl repository;
    private ScoreKeeperServiceImpl service;

    @BeforeEach
    public void setUp() {
        formatter = mock(ScoreFormatterImpl.class);
        repository = mock(ScoreKeeperRepositoryImpl.class);
        service = new ScoreKeeperServiceImpl(formatter, repository);
    }

    @Test
    public void incrementTeamAScore() {
        service.scoreTeamA(Points.ONE_POINT);
        verify(repository).incrementTeamAScore(Points.ONE_POINT);
    }

    @Test
    public void incrementTeamBScore() {
        service.scoreTeamB(Points.ONE_POINT);
        verify(repository).incrementTeamBScore(Points.ONE_POINT);
    }

    @Test
    public void getScore() {
        int expectedScoreTeamA = 100;
        int expectedScoreTeamB = 100;

        Map<String, Integer> expectedScores = new HashMap<>();
        expectedScores.put("teamA", expectedScoreTeamA);
        expectedScores.put("teamB", expectedScoreTeamB);

        when(repository.getScore()).thenReturn(expectedScores);

        String expectedFormattedScore = "100:100";
        when(formatter.format(expectedScoreTeamA, expectedScoreTeamB)).thenReturn(expectedFormattedScore);

        String actualScore = service.getScore();

        assertEquals(expectedFormattedScore, actualScore);
        verify(formatter).format(expectedScoreTeamA, expectedScoreTeamB);
    }
}
