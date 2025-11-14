package decorator.concretecomponent;

import decorator.component.CourseComponent;

public class BasicCourse implements CourseComponent {
    public String getDescription() {
        return "Basic Course";
    }
    public double getPrice() {
        return 50;
    }
}
