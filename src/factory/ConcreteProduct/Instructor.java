
package factory.ConcreteProduct;

import factory.product.User;

public class Instructor extends User {
    public Instructor(String name) {
        this.name = name;
    }

    @Override
    public void showRole() {
        System.out.println(name + " is an Instructor");
    }
}

