package builder;

import java.util.List;
import java.util.Map;

public class Course {
    private String title;
    private List<String> modules;
    private List<String> quizzes;
    private Map<String, String> metadata;


    public Course(CourseBuilder builder) {
        this.title = builder.title;
        this.modules = builder.modules;
        this.quizzes = builder.quizzes;
        this.metadata = builder.metadata;
    }

    // Геттеры
    public String getTitle() {
        return title;
    }

    public List<String> getModules() {
        return modules;
    }

    public List<String> getQuizzes() {
        return quizzes;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    @Override
    public String toString() {
        return "Course: " + title +
                ", Modules=" + modules +
                ", Quizzes=" + quizzes +
                ", Info=" + metadata;
    }
}
