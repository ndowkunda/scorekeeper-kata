import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreKeeperTest {
    @Test
    void shouldReturnInitialScoreOfZero() {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        String actualScore = scoreKeeper.getScore();
        String expectedScore = "000:000";
        assertThat(actualScore)
                .isEqualTo(expectedScore);
    }
    @ParameterizedTest
    @CsvSource({"1,001:000", "10,010:000", "100,100:000", "1000,999:000"})
    void shouldIncreaseTeamAScoreByOneAfterTeamAScoresOnePoint(int increment, String expectedScore) {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        for (int i = 0; i < increment; i++) {
            scoreKeeper.scoreTeamA1();
        }
        String actualScore = scoreKeeper.getScore();
        assertThat(actualScore).isEqualTo(expectedScore);
    }
    @ParameterizedTest
    @CsvSource({"1,000:001", "10,000:010", "100,000:100", "1000,000:999"})
    void shouldIncreaseTeamBScoreByOneAfterTeamBScoresOnePoint(int increment, String expectedScore) {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        for (int i = 0; i < increment; i++) {
            scoreKeeper.scoreTeamB1();
        }
        String actualScore = scoreKeeper.getScore();
        assertThat(actualScore).isEqualTo(expectedScore);
    }
    @ParameterizedTest
    @CsvSource({"1,002:000", "10,020:000", "100,200:000", "500,998:000"})
    void shouldIncreaseTeamAScoreByTwoAfterTeamAScoresTwoPoints(int increment, String expectedScore) {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        for (int i = 0; i < increment; i++) {
            scoreKeeper.scoreTeamA2();
        }
        String actualScore = scoreKeeper.getScore();
        assertThat(actualScore).isEqualTo(expectedScore);
    }
    @ParameterizedTest
    @CsvSource({"1,000:002, 10,000:020, 100,000:200, 500,000:998"})
    void shouldIncreaseTeamBScoreByTwoAfterTeamBScoresTwoPoints(int increment, String expectedScore) {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        for (int i = 0; i < increment; i++) {
            scoreKeeper.scoreTeamB2();
        }
        String actualScore = scoreKeeper.getScore();
        assertThat(actualScore).isEqualTo(expectedScore);
    }

    @ParameterizedTest
    @CsvSource({"1,003:000", "10,030:000", "100,300:000", "500,999:000"})
    void shouldIncreaseTeamAScoreByThreeAfterTeamAScoresThreePoints(int increment, String expectedScore) {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        for (int i = 0; i < increment; i++) {
            scoreKeeper.scoreTeamA3();
        }
        String actualScore = scoreKeeper.getScore();
        assertThat(actualScore).isEqualTo(expectedScore);
    }
    @ParameterizedTest
    @CsvSource({"1,000:003, 10,000:030, 100,000:300, 500,000:999"})
    void shouldIncreaseTeamBScoreByThreeAfterTeamBScoresThreePoints(int increment, String expectedScore) {
        ScoreKeeper scoreKeeper = new ScoreKeeper();
        for (int i = 0; i < increment; i++) {
            scoreKeeper.scoreTeamB3();
        }
        String actualScore = scoreKeeper.getScore();
        assertThat(actualScore).isEqualTo(expectedScore);
    }

}