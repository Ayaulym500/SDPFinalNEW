package strategy.strategy;

import java.util.List;
import builder.Course;

public interface RecommendationStrategy {
    List<Course> recommend(List<Course> courses);
}