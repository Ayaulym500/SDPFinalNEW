package strategy.context;

import strategy.strategy.ProgressStrategy;
import builder.Course;

public class CourseCompletionNotifier {

    private ProgressStrategy strategy;

    public CourseCompletionNotifier(ProgressStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ProgressStrategy strategy) {
        this.strategy = strategy;
    }

    public void notifyProgress(String student, int completedModules, int totalModules) {
        float percent = (float) (completedModules * 100.0 / totalModules);
        if (percent >= 100) {
            System.out.println(student + " has completed the course!");
        } else {
            System.out.println(strategy.trackProgress(student, completedModules, totalModules));
        }
    }
}