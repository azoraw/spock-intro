package com.azoraw.spockintro.dependency_injection;

public class Parent {

    private final Child child;

    public Parent(Child child) {
        this.child = child;
    }

    public void readChildABook() {
        child.sleep();
    }

    public String getToyName(String toyType) {
       return child.getToy(toyType).getName();
    }
}
