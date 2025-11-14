package app;

import bridge.ConcreteImplementations.MobilePlatform;
import bridge.ConcreteImplementations.WebPlatform;
import bridge.RefinedAbstraction.QuizContent;
import bridge.RefinedAbstraction.VideoContent;
import bridge.abstraction.CourseContent;
import builder.*;
import decorator.component.CourseComponent;
import decorator.concreatedecorator.BonusMaterialDecorator;
import decorator.concreatedecorator.CertificateDecorator;
import decorator.concretecomponent.BasicCourse;
import factory.Creator.UserFactory;
import factory.product.User;
import strategy.concreteStrategy.PopularityStrategy;
import strategy.context.RecommendationEngine;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Builder
        Course javaCourse = new CourseBuilder()
                .setTitle("Java Programming")
                .addModule("OOP Basics")
                .addModule("Design Patterns")
                .addQuiz("Final Quiz")
                .addInfo("level", "Intermediate")
                .build();

        System.out.println(javaCourse);

        // Factory
        User student = UserFactory.createUser("student", "Aya");
        User instructor = UserFactory.createUser("instructor", "Talgat");
        student.showRole();
        instructor.showRole();

        // Strategy
        List<Course> courses = List.of(javaCourse);
        RecommendationEngine engine = new RecommendationEngine(new PopularityStrategy());
        engine.recommend(courses)
                .forEach(c -> System.out.println("Recommended: " + c.getTitle()));

        // Decorator
        CourseComponent decorated = new BonusMaterialDecorator(
                new CertificateDecorator(new BasicCourse()));
        System.out.println(decorated.getDescription() + " | Price: " + decorated.getPrice());

        // Bridge
        CourseContent video = new VideoContent(new WebPlatform());
        CourseContent quiz = new QuizContent(new MobilePlatform());
        video.showContent();
        quiz.showContent();
    }
}
