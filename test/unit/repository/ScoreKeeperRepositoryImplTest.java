package unit.repository;

import domain.scorekeeper.Points;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ScoreKeeperRepositoryImpl;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreKeeperRepositoryImplTest {
    private ScoreKeeperRepositoryImpl repository;

    @BeforeEach
    public void setUp() {
        repository = new ScoreKeeperRepositoryImpl();

    }

    @Test
    public void shouldIncrementTeamAScore() {
        repository.incrementTeamAScore(Points.ONE_POINT);

        Map<String, Integer> scores = repository.getScore();
        int scoreTeamA = scores.get("teamA");
        int actualScore = 1;

        assertEquals(scoreTeamA, actualScore);
    }

    @Test
    public void shouldIncrementTeamBScore() {
        repository.incrementTeamBScore(Points.TWO_POINTS);

        Map<String, Integer> scores = repository.getScore();
        int scoreTeamB = scores.get("teamB");
        int actualScore = 2;

        assertEquals(scoreTeamB, actualScore);
    }

    @Test
    public void shouldGetScoreForBothTeams() {
        repository.incrementTeamAScore(Points.THREE_POINTS);
        repository.incrementTeamBScore(Points.THREE_POINTS);

        Map<String, Integer> scores = repository.getScore();
        int scoreTeamA = scores.get("teamA");
        int scoreTeamB = scores.get("teamB");

        int actualScoreTeamA = 3;
        int actualScoreTeamB = 3;

        assertEquals(actualScoreTeamA, scoreTeamA);
        assertEquals(actualScoreTeamB, scoreTeamB);


    }

}
