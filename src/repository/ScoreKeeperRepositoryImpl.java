package repository;

import domain.scorekeeper.Points;
import domain.scorekeeper.ScoreFormatter;


public class ScoreKeeperRepositoryImpl implements ScoreKeeperRepository {
    private int scoreTeamA;
    private int scoreTeamB;
    private final ScoreFormatter scoreFormatter;

    public ScoreKeeperRepositoryImpl(ScoreFormatter scoreFormatter) {
        this.scoreFormatter = scoreFormatter;
        scoreTeamA = 0;
        scoreTeamB = 0;
    }

    @Override
    public void incrementTeamAScore(Points points) {
        int point = points.getValue();
        if (scoreTeamA < Points.LIMIT.getValue() - point) {
            scoreTeamA += point;
        }
    }

    @Override
    public void incrementTeamBScore(Points points) {
        int point = points.getValue();
        if (scoreTeamB < Points.LIMIT.getValue() - point) {
            scoreTeamB += point;
        }
    }

    @Override
    public String getScore() {
        return scoreFormatter.format(scoreTeamA, scoreTeamB);
    }
}
