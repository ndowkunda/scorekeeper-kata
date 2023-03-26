package service;

import domain.scorekeeper.Points;

public interface ScoreKeeperService {
    void scoreTeamA(Points points);

    void scoreTeamB(Points points);

    String getScore();

}
