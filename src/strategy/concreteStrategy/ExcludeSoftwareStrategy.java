package strategy.concreteStrategy;

import java.util.List;
import java.util.stream.Collectors;
import builder.Course;
import strategy.strategy.RecommendationStrategy;

public class ExcludeSoftwareStrategy implements RecommendationStrategy {

    private Course mainCourse;

    public ExcludeSoftwareStrategy(Course mainCourse) {
        this.mainCourse = mainCourse;
    }

    @Override
    public List<Course> recommend(List<Course> courses) {
        return courses.stream()
                .filter(c -> !c.equals(mainCourse))
                .collect(Collectors.toList());
    }
}


