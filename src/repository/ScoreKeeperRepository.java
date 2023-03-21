package repository;

import domain.scorekeeper.Points;

public interface ScoreKeeperRepository {
    void incrementTeamAScore(Points points);

    void incrementTeamBScore(Points points);

    String getScore();

}
