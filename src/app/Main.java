package app;

import bridge.ConcreteImplementations.ApplePayPlatform;
import bridge.ConcreteImplementations.Cash;
//import bridge.ConcreteImplementations.MobilePlatform;
import bridge.ConcreteImplementations.VisaPlatform;
//import bridge.ConcreteImplementations.WebPlatform;
import bridge.RefinedAbstraction.OfflinePayment;
import bridge.RefinedAbstraction.OnlinePayment;
//import bridge.RefinedAbstraction.QuizContent;
//import bridge.RefinedAbstraction.VideoContent;
//import bridge.abstraction.CourseContent;
import bridge.abstraction.PaymentContent;
import builder.*;
import decorator.component.CourseComponent;
import decorator.concreatedecorator.BonusMaterialDecorator;
import decorator.concreatedecorator.CertificateDecorator;
import decorator.concretecomponent.BasicCourse;
import factory.Creator.UserFactory;
import factory.product.User;
import observer.publisher.OnlineEducationPlatform;
import observer.publisher.Student;
import strategy.concreteStrategy.ExcludeSoftwareStrategy;
import strategy.context.RecommendationEngine;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Builder
        Course javaCourse = new CourseBuilder()
                .setTitle("Software design pattern")
                .addModule("Structural")
                .addModule("Creational")
                .addModule("Behavioral Design pattern")
                .addQuiz("Final Quiz")
                .addInfo("level", "Intermediate")
                .build();

        Course pythonCourse = new CourseBuilder()
                .setTitle("Python Programming")
                .addModule("Pandas")
                .addModule("API")
                .addModule("Data Analysis")
                .addQuiz("Final")
                .addInfo("level", "Advanced")
                .build();

        Course cppCourse = new CourseBuilder()
                .setTitle("C++ Programming")
                .addModule("Syntax")
                .addModule("Pointers")
                .addModule("OOP in C++")
                .addQuiz("Final")
                .addInfo("level", "Intermediate")
                .build();

        List<Course> courses = List.of(javaCourse, pythonCourse, cppCourse);

        Course mainCourse = javaCourse;
        System.out.println(mainCourse);

        // Factory
        User student1 = UserFactory.createUser("student", "Aya");
        User student2 = UserFactory.createUser("student", "Marat");
        User teacher = UserFactory.createUser("teacher", "Talgat");

        student1.showRole();
        student2.showRole();
        teacher.showRole();

        // Decorator
        CourseComponent decorated = new BonusMaterialDecorator(
                new CertificateDecorator(new BasicCourse()));
        System.out.println(decorated.getDescription() + " | Price: " + decorated.getPrice());

        // Bridge

        PaymentContent onlinePayment = new OnlinePayment(new ApplePayPlatform());
        PaymentContent offlinePaymentCash = new OfflinePayment(new Cash());
        PaymentContent offlinePaymentVisa = new OfflinePayment(new VisaPlatform());

        onlinePayment.processPayment();
        offlinePaymentCash.processPayment();
        offlinePaymentVisa.processPayment();

        // Strategy
        RecommendationEngine engine = new RecommendationEngine(
                new ExcludeSoftwareStrategy(mainCourse)
        );
        engine.recommend(courses)
                .forEach(c -> System.out.println("Recommended: " + c.getTitle()));

        //observer

        OnlineEducationPlatform platform = new OnlineEducationPlatform();

        Student studentAya = new Student("Aya");
        Student studentMarat = new Student("Marat");

        platform.register(studentAya);
        platform.register(studentMarat);

        platform.newWebinar("Java for beginners");
        platform.promotion("50% discount on all courses until the end of the month");
        platform.unregister(studentMarat);

        platform.newWebinar("Advanced Python");
    }
}
