package strategy.concreteStrategy;

import strategy.strategy.ProgressStrategy;
import builder.Course;

public class InstructorLedStrategy implements ProgressStrategy {
    private Course course;

    public InstructorLedStrategy(Course course) {
        this.course = course;
    }

    @Override
    public String trackProgress(String student, int completedModules, int totalModules) {
        float percent = (float) (completedModules * 100.0 / totalModules);
        return student + " is following the instructor-led schedule: " + String.format("%.2f", percent) + "% completed.";
    }
}