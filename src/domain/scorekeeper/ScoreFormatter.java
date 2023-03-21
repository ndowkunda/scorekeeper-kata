package domain.scorekeeper;

public class ScoreFormatter {
    public String format(int scoreTeamA, int scoreTeamB) {
        return String.format("%03d:%03d", scoreTeamA, scoreTeamB);
    }

}
