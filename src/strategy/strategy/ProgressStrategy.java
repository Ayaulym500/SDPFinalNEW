package strategy.strategy;

import builder.Course;

public interface ProgressStrategy {
    String trackProgress(String student, int completedModules, int totalModules);
}