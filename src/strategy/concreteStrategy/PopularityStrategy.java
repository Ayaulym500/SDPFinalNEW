package strategy.concreteStrategy;

import java.util.List;
import builder.Course;
import strategy.strategy.RecommendationStrategy;

public class PopularityStrategy implements RecommendationStrategy {
    public List<Course> recommend(List<Course> courses) {
        return courses;
    }
}