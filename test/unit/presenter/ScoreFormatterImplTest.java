package unit.presenter;


import presenter.ScoreFormatterImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreFormatterImplTest {

    private ScoreFormatterImpl scoreFormatterImpl;

    @BeforeEach
    public void setUp() {
        scoreFormatterImpl = new ScoreFormatterImpl();
    }

    @Test
    void shouldFormatSingleDigitScores() {
        String formattedScore = scoreFormatterImpl.format(1, 1);
        assertEquals("001:001", formattedScore);
    }

    @Test
    void shouldFormatDoubleDigitScores() {
        String formattedScore = scoreFormatterImpl.format(10, 10);
        assertEquals("010:010", formattedScore);
    }

    @Test
    void shouldFormatTripleDigitScores() {
        String formattedScore = scoreFormatterImpl.format(999, 999);
        assertEquals("999:999", formattedScore);
    }

    @Test
    void shouldFormatZeroScores() {
        String formattedScore;
        formattedScore = scoreFormatterImpl.format(0, 0);
        assertEquals("000:000", formattedScore);
    }
}





