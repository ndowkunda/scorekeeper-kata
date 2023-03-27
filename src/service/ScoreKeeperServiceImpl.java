package service;

import domain.scorekeeper.Points;
import presenter.ScoreFormatter;
import repository.ScoreKeeperRepository;

import java.util.Map;

public class ScoreKeeperServiceImpl implements ScoreKeeperService {
    private final ScoreFormatter formatter;

    private final ScoreKeeperRepository repository;

    public ScoreKeeperServiceImpl(ScoreFormatter formatter, ScoreKeeperRepository repository) {
        this.formatter = formatter;
        this.repository = repository;

    }

    public void scoreTeamA(Points points) {
        repository.incrementTeamAScore(points);

    }

    @Override
    public void scoreTeamB(Points points) {
        repository.incrementTeamBScore(points);

    }

    @Override
    public String getScore() {
        Map<String, Integer> scores = repository.getScore();
        int scoreTeamA = scores.get("teamA");
        int scoreTeamB = scores.get("teamB");
        return formatter.format(scoreTeamA, scoreTeamB);
    }

}
