package service;

import domain.scorekeeper.Points;
import repository.ScoreKeeperRepository;

public class ScoreKeeperServiceImpl implements ScoreKeeperService {
    private final ScoreKeeperRepository repository;

    public ScoreKeeperServiceImpl(ScoreKeeperRepository repository) {
        this.repository = repository;

    }

    public void incrementTeamAScore(Points points) {
        repository.incrementTeamAScore(points);

    }

    @Override
    public void incrementTeamBScore(Points points) {
        repository.incrementTeamBScore(points);

    }

    @Override
    public String getScore() {
        return repository.getScore();
    }
}
