package strategy.concreteStrategy;

import strategy.strategy.ProgressStrategy;
import builder.Course;

public class SelfPacedStrategy implements ProgressStrategy {

    private Course course;

    public SelfPacedStrategy(Course course) {
        this.course = course;
    }

    @Override
    public String trackProgress(String student, int completedModules, int totalModules) {
        float percent = (float) (completedModules * 100.0 / totalModules);
        return student + " is learning at their own pace: " + String.format("%.2f", percent) + "% completed.";
    }
}