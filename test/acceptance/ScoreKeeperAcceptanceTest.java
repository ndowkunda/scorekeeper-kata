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

        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamB2();
        scoreKeeper.scoreTeamA3();
        scoreKeeper.scoreTeamB3();

        assertEquals("006:006", scoreKeeper.getScore());

    }

    @Test
    void shouldReturnDoubleDigitScoresForBothTeamsAfterButtonsPressed() {

        scoreKeeper.scoreTeamA1();
        scoreKeeper.scoreTeamB1();
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamB2();
        scoreKeeper.scoreTeamA2();
        scoreKeeper.scoreTeamB2();
        scoreKeeper.scoreTeamA3();
        scoreKeeper.scoreTeamB3();
        scoreKeeper.scoreTeamA3();
        scoreKeeper.scoreTeamB3();


        assertEquals("011:011", scoreKeeper.getScore());
    }
}
