package domain.scorekeeper;

import service.ScoreKeeperService;

public class ScoreKeeper {
    private final ScoreKeeperService service;

    public ScoreKeeper(ScoreKeeperService service) {
        this.service = service;
    }

    public String getScore() {
        return service.getScore();
    }

    public void scoreTeamA1() {
        service.incrementTeamAScore(Points.ONE_POINT);
    }

    public void scoreTeamB1() {
        service.incrementTeamBScore(Points.ONE_POINT);
    }

    public void scoreTeamA2() {
        service.incrementTeamAScore(Points.TWO_POINTS);
    }


    public void scoreTeamB2() {
        service.incrementTeamBScore(Points.TWO_POINTS);
    }

    public void scoreTeamA3() {
        service.incrementTeamAScore(Points.THREE_POINTS);
    }

    public void scoreTeamB3() {
        service.incrementTeamBScore(Points.THREE_POINTS);
    }
}

