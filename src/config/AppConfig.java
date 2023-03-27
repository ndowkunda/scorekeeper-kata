package config;

import domain.scorekeeper.Points;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import presenter.ScoreFormatter;
import presenter.ScoreFormatterImpl;
import repository.ScoreKeeperRepository;
import repository.ScoreKeeperRepositoryImpl;
import service.ScoreKeeperService;
import service.ScoreKeeperServiceImpl;

@Configuration
public class AppConfig {

    // Define beans for the various point values
    @Bean
    public Points limit() {
        return Points.LIMIT;
    }

    @Bean
    public Points onePoint() {
        return Points.ONE_POINT;
    }

    @Bean
    public Points twoPoints() {
        return Points.TWO_POINTS;
    }

    @Bean
    public Points threePoints() {
        return Points.THREE_POINTS;
    }

    // Define beans for the presenter interface and implementation
    @Bean
    public ScoreFormatter scoreFormatter() {
        return new ScoreFormatterImpl();
    }

    // Define beans for the repository interface and implementation
    @Bean
    public ScoreKeeperRepository scoreKeeperRepository() {
        return new ScoreKeeperRepositoryImpl();
    }

    // Define beans for the service interface and implementation
    @Bean
    public ScoreKeeperService scoreKeeperService() {
        return new ScoreKeeperServiceImpl(scoreFormatter(), scoreKeeperRepository());
    }

}
