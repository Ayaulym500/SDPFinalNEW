package factory.ConcreteProduct;

import factory.product.User;

public class Student extends User {
    public Student(String name) {
        this.name = name;
    }
    public void showRole() {
        System.out.println(name + " is a Student");
    }
}
