import org.junit.jupiter.api.Test;

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

}