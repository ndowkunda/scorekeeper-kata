package service;

import domain.scorekeeper.Points;
import presenter.ScoreFormatterImpl;
import repository.ScoreKeeperRepository;

import java.util.Map;

public class ScoreKeeperServiceImpl implements ScoreKeeperService {
    private final ScoreFormatterImpl formatter;

    private final ScoreKeeperRepository repository;

    public ScoreKeeperServiceImpl(ScoreFormatterImpl formatter, ScoreKeeperRepository repository) {
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
        System.out.println(scores);
        int scoreTeamA = scores.get("teamA");
        int scoreTeamB = scores.get("teamB");
        return formatter.format(scoreTeamA, scoreTeamB);
    }

}
