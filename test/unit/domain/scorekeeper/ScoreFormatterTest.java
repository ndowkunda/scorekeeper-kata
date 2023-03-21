package unit.domain.scorekeeper;


import domain.scorekeeper.ScoreFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreFormatterTest {

    private ScoreFormatter scoreFormatter;

    @BeforeEach
    public void setUp() {
        scoreFormatter = new ScoreFormatter();
    }

    @Test
    void shouldFormatOneDigitScores() {
        String formattedScore = scoreFormatter.format(1, 1);
        assertEquals("001:001", formattedScore);
    }

    @Test
    void shouldFormatTwoDigitScores() {
        String formattedScore = scoreFormatter.format(10, 10);
        assertEquals("020:003", formattedScore);
    }

    @Test
    void shouldFormatThreeDigitScores() {
        String formattedScore = scoreFormatter.format(999, 999);
        assertEquals("000:000", formattedScore);
    }

    @Test
    void shouldFormatZeroScores() {
        String formattedScore;
        formattedScore = scoreFormatter.format(0, 0);
        assertEquals("000:000", formattedScore);
    }
}





