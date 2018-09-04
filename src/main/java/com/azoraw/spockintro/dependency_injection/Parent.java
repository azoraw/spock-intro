package com.azoraw.spockintro.dependency_injection;

public class Parent {

    private final Child child;

    public Parent(Child child) {
        this.child = child;
    }

    public void giveChildAToy() {
        child.setNumberOfToys(child.getNumberOfToys() + 1);
    }

    public String giveChildAToyAndSeeResponse(int numberOfToys) {
       return child.giveToy(numberOfToys).getChildMsg();
    }
}
