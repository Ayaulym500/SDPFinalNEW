package strategy.context;

import java.util.List;
import builder.Course;
import strategy.strategy.RecommendationStrategy;

public class RecommendationEngine {
    private RecommendationStrategy strategy;

    public RecommendationEngine(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RecommendationStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Course> recommend(List<Course> allCourses) {
        return strategy.recommend(allCourses);
    }
}