package acceptance;

import domain.scorekeeper.ScoreFormatter;
import domain.scorekeeper.ScoreKeeper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.ScoreKeeperRepository;
import repository.ScoreKeeperRepositoryImpl;
import service.ScoreKeeperService;
import service.ScoreKeeperServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreKeeperAcceptanceTest {
    ScoreKeeper scoreKeeper;

    @BeforeEach
    public void setUp() {

        ScoreFormatter scoreFormatter = new ScoreFormatter();
        ScoreKeeperRepository repository = new ScoreKeeperRepositoryImpl(scoreFormatter);
        ScoreKeeperService service = new ScoreKeeperServiceImpl(repository);
        scoreKeeper = new ScoreKeeper(service);
    }

    @Test
    void shouldReturnBothTeamsScoreAfterEveryButtonPressedOnce() {

        scoreTeam("A1", 1);
        scoreTeam("A2", 1);
        scoreTeam("A3", 1);
        scoreTeam("B1", 1);
        scoreTeam("B2", 1);
        scoreTeam("B3", 1);

        assertEquals("006:006", scoreKeeper.getScore());

    }

    @Test
    void shouldReturnDoubleDigitScoresForBothTeamsAfterButtonsPressed() {
        scoreTeam("A1", 1);
        scoreTeam("A2", 2);
        scoreTeam("A3", 2);
        scoreTeam("B1", 1);
        scoreTeam("B2", 2);
        scoreTeam("B3", 2);

        assertEquals("011:011", scoreKeeper.getScore());
    }

    @Test
    void shouldReturnTripleDigitScoresForBothTeamsAfterButtonsPressed() {
        scoreTeam("A1", 100);
        scoreTeam("A2", 1);
        scoreTeam("A3", 1);
        scoreTeam("B1", 100);
        scoreTeam("B2", 1);
        scoreTeam("B3", 1);

        assertEquals("105:105", scoreKeeper.getScore());
    }

    private void scoreTeam(String button, int round) {
        for (int i = 0; i < round; i++) {
            switch (button) {
                case "A1" -> scoreKeeper.scoreTeamA1();
                case "A2" -> scoreKeeper.scoreTeamA2();
                case "A3" -> scoreKeeper.scoreTeamA3();
                case "B1" -> scoreKeeper.scoreTeamB1();
                case "B2" -> scoreKeeper.scoreTeamB2();
                case "B3" -> scoreKeeper.scoreTeamB3();
            }
        }
    }
}












