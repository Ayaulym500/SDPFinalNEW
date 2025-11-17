package strategy.concreteStrategy;

import strategy.strategy.ProgressStrategy;
import builder.Course;

public class HybridStrategy implements ProgressStrategy {

    private Course course;

    public HybridStrategy(Course course) {
        this.course = course;
    }


    @Override
    public String trackProgress(String student, int completedModules, int totalModules) {
        float percent = (float) (completedModules * 100.0 / totalModules);
        return student + " is on a hybrid schedule: " + String.format("%.2f", percent) + "% completed.";
    }
}


