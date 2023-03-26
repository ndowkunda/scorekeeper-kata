package repository;

import domain.scorekeeper.Points;

import java.util.HashMap;
import java.util.Map;


public class ScoreKeeperRepositoryImpl implements ScoreKeeperRepository {
    private final Map<String, Integer> scores;

    public ScoreKeeperRepositoryImpl() {
        scores = new HashMap<>();
        scores.put("teamA", 0);
        scores.put("teamB", 0);
    }

    @Override
    public void incrementTeamAScore(Points points) {
        incrementTeamScore("teamA", points);
    }

    @Override
    public void incrementTeamBScore(Points points) {
        incrementTeamScore("teamB", points);
    }

    @Override
    public Map<String, Integer> getScore() {
        return scores;
    }

    private void incrementTeamScore(String team, Points points) {
        int point = points.getValue();
        int currentScore = scores.get(team);
        if (currentScore < Points.LIMIT.getValue() - point) {
            scores.put(team, currentScore + point);
        }
    }
}
