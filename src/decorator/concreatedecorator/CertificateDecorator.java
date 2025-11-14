package decorator.concreatedecorator;

import decorator.basedecorator.CourseDecorator;
import decorator.component.CourseComponent;

public class CertificateDecorator extends CourseDecorator {
    public CertificateDecorator(CourseComponent course){
        super(course);
    }
    public String getDescription(){
        return course.getDescription() + " + Certificate";
    }
    public double getPrice(){
        return course.getPrice() + 20;
    }
}
