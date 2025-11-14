package decorator.basedecorator;

import decorator.component.CourseComponent;

public abstract class CourseDecorator implements CourseComponent {
    protected CourseComponent course;
    public CourseDecorator(CourseComponent course) {
        this.course = course;
    }
}
