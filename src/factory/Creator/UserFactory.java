package factory.Creator;

import factory.ConcreteProduct.Teacher;
import factory.ConcreteProduct.Student;
import factory.product.User;

public class UserFactory {
    public static User createUser(String type, String name) {
        User user = null;

        if (type.equals("student")) {
            user = new Student(name);
        } else if (type.equals("teacher")) {
            user = new Teacher(name);
        } else {
            System.out.println("Unknown user type!");
        }

        return user;
    }
}
