public class ScoreKeeper {
    public static final int SCORE_LIMIT = 999;
    private String score = "000:000";

    public String getScore() {
        return score;
    }

    public void scoreTeamA1() {
        String scoreTeamA = score.substring(0, 3);
        int scoreTeamAInt = Integer.parseInt(scoreTeamA);
        if(scoreTeamAInt < SCORE_LIMIT) {
            scoreTeamAInt++;
        }
        String scoreTeamAStr = String.format("%03d",scoreTeamAInt);
        String scoreTeamBStr = score.substring(3);
        score = scoreTeamAStr + scoreTeamBStr;
    }

    public void scoreTeamB1() {
        String scoreTeamB = score.substring( 4);
        int scoreTeamBInt = Integer.parseInt(scoreTeamB);
        if(scoreTeamBInt < SCORE_LIMIT) {
            scoreTeamBInt++;
        }
        String scoreTeamBStr = String.format("%03d", scoreTeamBInt);
        String scoreTeamAStr = score.substring(0,4);
        score = scoreTeamAStr + scoreTeamBStr;
    }

    public void scoreTeamA2() {
        String scoreTeamA = score.substring(0, 3);
        int scoreTeamAInt = Integer.parseInt(scoreTeamA);
        if(scoreTeamAInt < SCORE_LIMIT - 1) {
            scoreTeamAInt+= 2;
        }
        String scoreTeamAStr = String.format("%03d",scoreTeamAInt);
        String scoreTeamBStr = score.substring(3);
        score = scoreTeamAStr + scoreTeamBStr;
    }
}
