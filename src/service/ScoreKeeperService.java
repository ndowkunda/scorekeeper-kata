package service;

import domain.scorekeeper.Points;

public interface ScoreKeeperService {
    void incrementTeamAScore(Points points);

    void incrementTeamBScore(Points points);

    String getScore();

}
