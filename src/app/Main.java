package app;

import bridge.ConcreteImplementations.ApplePayPlatform;
import bridge.ConcreteImplementations.Cash;
import bridge.ConcreteImplementations.VisaPlatform;
import bridge.RefinedAbstraction.OfflinePayment;
import bridge.RefinedAbstraction.OnlinePayment;

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
import strategy.concreteStrategy.HybridStrategy;
import strategy.concreteStrategy.InstructorLedStrategy;
import strategy.concreteStrategy.SelfPacedStrategy;
import strategy.context.CourseCompletionNotifier;
import strategy.context.CourseProgressTracker;

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

        System.out.println();
        System.out.println("Academic performance");
        // Strategy
        CourseProgressTracker tracker = new CourseProgressTracker(new SelfPacedStrategy(mainCourse));
        CourseCompletionNotifier notifier = new CourseCompletionNotifier(new SelfPacedStrategy(mainCourse));

        tracker.showProgress("Aya", 2, 5);
        tracker.showProgress("Marat", 3, 5);


        tracker.setStrategy(new InstructorLedStrategy(mainCourse));
        tracker.showProgress("Aya", 2, 5);

        notifier.notifyProgress("Marat", 5, 5);


        tracker.setStrategy(new HybridStrategy(mainCourse));
        notifier.setStrategy(new HybridStrategy(mainCourse));

        notifier.notifyProgress("Aya", 4, 5);

        //observer
        System.out.println();
        System.out.println("New messages for student");
        OnlineEducationPlatform platform = new OnlineEducationPlatform();

        Student studentAya = new Student("Aya");
        Student studentMarat = new Student("Marat");

        platform.register(studentAya);
        platform.register(studentMarat);

        platform.newWebinar("Java for beginners");
        platform.promotion("50% discount on all courses until the end of the month");
        platform.unregister(studentMarat);

        platform.newWebinar("Advanced Python");

        System.out.println();
        System.out.println("Payment for this month");
        // Decorator
        CourseComponent basicCourse = new BasicCourse();
        CourseComponent certifiedCourse = new CertificateDecorator(basicCourse);
        CourseComponent decoratedCourse = new BonusMaterialDecorator(certifiedCourse);
        System.out.println(decoratedCourse.getDescription() + " | Price: " + decoratedCourse.getPrice());

        // Bridge

        PaymentContent onlinePayment = new OnlinePayment(new ApplePayPlatform());
        PaymentContent offlinePaymentCash = new OfflinePayment(new Cash());
        PaymentContent offlinePaymentVisa = new OfflinePayment(new VisaPlatform());

        onlinePayment.processPayment();
        offlinePaymentCash.processPayment();
        offlinePaymentVisa.processPayment();
    }
}
