package decorator.concreatedecorator;

import decorator.basedecorator.CourseDecorator;
import decorator.component.CourseComponent;

public class BonusMaterialDecorator extends CourseDecorator {
    public BonusMaterialDecorator(CourseComponent course){
        super(course);
    }
    public String getDescription(){
        return course.getDescription() + " + Bonus Material";
    }
    public double getPrice(){
        return course.getPrice() + 10;
    }
}
