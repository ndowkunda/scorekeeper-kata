package acceptance;

import domain.scorekeeper.Points;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import presenter.ScoreFormatterImpl;
import repository.ScoreKeeperRepositoryImpl;
import service.ScoreKeeperServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreKeeperAcceptanceTest {
    ScoreKeeperServiceImpl service;

    @BeforeEach
    public void setUp() {

        ScoreFormatterImpl formatter = new ScoreFormatterImpl();
        ScoreKeeperRepositoryImpl repository = new ScoreKeeperRepositoryImpl();
        service = new ScoreKeeperServiceImpl(formatter, repository);
    }

    @Test
    void shouldReturnBothTeamsScoreAfterEveryButtonPressedOnce() {

        scoreTeam("A1", 1);
        scoreTeam("A2", 1);
        scoreTeam("A3", 1);
        scoreTeam("B1", 1);
        scoreTeam("B2", 1);
        scoreTeam("B3", 1);

        assertEquals("006:006", service.getScore());

    }

    @Test
    void shouldReturnDoubleDigitScoresForBothTeamsAfterButtonsPressed() {
        scoreTeam("A1", 1);
        scoreTeam("A2", 2);
        scoreTeam("A3", 2);
        scoreTeam("B1", 1);
        scoreTeam("B2", 2);
        scoreTeam("B3", 2);

        assertEquals("011:011", service.getScore());
    }

    @Test
    void shouldReturnTripleDigitScoresForBothTeamsAfterButtonsPressed() {
        scoreTeam("A1", 100);
        scoreTeam("A2", 1);
        scoreTeam("A3", 1);
        scoreTeam("B1", 100);
        scoreTeam("B2", 1);
        scoreTeam("B3", 1);

        assertEquals("105:105", service.getScore());
    }

    private void scoreTeam(String button, int round) {
        for (int i = 0; i < round; i++) {
            switch (button) {
                case "A1" -> service.scoreTeamA(Points.ONE_POINT);
                case "A2" -> service.scoreTeamA(Points.TWO_POINTS);
                case "A3" -> service.scoreTeamA(Points.THREE_POINTS);
                case "B1" -> service.scoreTeamB(Points.ONE_POINT);
                case "B2" -> service.scoreTeamB(Points.TWO_POINTS);
                case "B3" -> service.scoreTeamB(Points.THREE_POINTS);
            }
        }
    }
}












