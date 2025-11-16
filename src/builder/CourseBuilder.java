package builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseBuilder {
    String title;
    List<String> modules = new ArrayList<>();
    List<String> quizzes = new ArrayList<>();
    Map<String, String> metadata = new HashMap<>();

    public CourseBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public CourseBuilder addModule(String module) {
        modules.add(module);
        return this;
    }

    public CourseBuilder addQuiz(String quiz) {
        quizzes.add(quiz);
        return this;
    }

    public CourseBuilder addInfo(String key, String value) {
        metadata.put(key, value);
        return this;
    }

    public Course build() {
        return new Course(this);
    }
}