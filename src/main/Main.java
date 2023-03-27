package main;

import config.AppConfig;
import domain.scorekeeper.Points;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.ScoreKeeperService;

public class Main {
    public static void main(String[] args) {
        // Create an application context with the AppConfig class
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Retrieve a bean of ScoreKeeperService from the context
        ScoreKeeperService scoreKeeperService = context.getBean(ScoreKeeperService.class);

        // Score points for Team A and B using different values of Points
        scoreKeeperService.scoreTeamA(Points.ONE_POINT);
        scoreKeeperService.scoreTeamB(Points.ONE_POINT);
        scoreKeeperService.scoreTeamA(Points.TWO_POINTS);
        scoreKeeperService.scoreTeamB(Points.TWO_POINTS);
        scoreKeeperService.scoreTeamA(Points.THREE_POINTS);
        scoreKeeperService.scoreTeamB(Points.THREE_POINTS);

        // Print the final score of both teams
        System.out.println(scoreKeeperService.getScore());
    }
}

