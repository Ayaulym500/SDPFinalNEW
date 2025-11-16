
package factory.ConcreteProduct;

import factory.product.User;

public class Teacher extends User {
    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void showRole() {
        System.out.println(name + " is an Teacher");
    }
}

