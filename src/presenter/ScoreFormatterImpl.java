package presenter;

public class ScoreFormatterImpl implements ScoreFormatter {

    @Override
    public String format(int scoreTeamA, int scoreTeamB) {
        return String.format("%03d:%03d", scoreTeamA, scoreTeamB);
    }
}
