package repository;

import domain.scorekeeper.Points;

import java.util.Map;

public interface ScoreKeeperRepository {
    void incrementTeamAScore(Points points);

    void incrementTeamBScore(Points points);

    Map<String, Integer> getScore();

}
