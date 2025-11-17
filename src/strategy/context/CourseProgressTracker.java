package strategy.context;

import strategy.strategy.ProgressStrategy;
import builder.Course;

public class CourseProgressTracker {

    private ProgressStrategy strategy;

    public CourseProgressTracker(ProgressStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ProgressStrategy strategy) {
        this.strategy = strategy;
    }

    public void showProgress(String student, int completedModules, int totalModules) {
        System.out.println(strategy.trackProgress(student, completedModules, totalModules));
    }
}
