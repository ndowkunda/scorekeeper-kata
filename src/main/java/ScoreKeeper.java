public class ScoreKeeper {
    private static final int SCORE_LIMIT = 1000;
    private static final int ONE_POINT = 1;
    private static final int TWO_POINTS = 2;
    private static final int THREE_POINTS = 3;

    private String score = "000:000";
    private String teamA;
    private String teamB;

    public String getScore() {
        return score;
    }

    public void scoreTeamA1() {
        teamA = score.substring(0,3);
        teamB = score.substring(4);
        int scoreTeamAInt = getTeamScore(teamA);
        scoreTeamAInt = incrementScore(scoreTeamAInt,ONE_POINT);
        updateScore(scoreTeamAInt,getTeamScore(teamB));
    }

    public void scoreTeamB1() {
        teamA = score.substring(0,3);
        teamB = score.substring(4);
        int scoreTeamBInt = getTeamScore(teamB);
        scoreTeamBInt = incrementScore(scoreTeamBInt,ONE_POINT);
        updateScore(getTeamScore(teamA),scoreTeamBInt);
    }

    public void scoreTeamA2() {
        teamA = score.substring(0,3);
        teamB = score.substring(4);
        int scoreTeamAInt = getTeamScore(teamA);
        scoreTeamAInt = incrementScore(scoreTeamAInt,TWO_POINTS);
        updateScore(scoreTeamAInt,getTeamScore(teamB));
    }


    public void scoreTeamB2() {
        teamA = score.substring(0,3);
        teamB = score.substring(4);
        int scoreTeamBInt = getTeamScore(teamB);
        scoreTeamBInt = incrementScore(scoreTeamBInt, TWO_POINTS);
        updateScore(getTeamScore(teamA), scoreTeamBInt);
    }

    public void scoreTeamA3() {
        teamA = score.substring(0,3);
        teamB = score.substring(4);
        int scoreTeamAInt = getTeamScore(teamA);
        scoreTeamAInt = incrementScore(scoreTeamAInt,THREE_POINTS);
        updateScore(scoreTeamAInt,getTeamScore(teamB));
    }

    public void scoreTeamB3() {
        teamA = score.substring(0,3);
        teamB = score.substring(4);
        int scoreTeamBInt = getTeamScore(teamB);
        scoreTeamBInt = incrementScore(scoreTeamBInt, THREE_POINTS);
        updateScore(getTeamScore(teamA), scoreTeamBInt);
    }

    private int getTeamScore(String teamScore) {
        return Integer.parseInt(teamScore);
    }

    private static int incrementScore(int score, int point) {
        if(score < SCORE_LIMIT - point) {
            score += point;
        }
        return score;
    }

    private void updateScore(int teamAScore, int teamBScore) {
        String scoreTeamAStr = String.format("%03d", teamAScore);
        String scoreTeamBStr = String.format("%03d", teamBScore);
        score = scoreTeamAStr + ":" + scoreTeamBStr;
    }

}
