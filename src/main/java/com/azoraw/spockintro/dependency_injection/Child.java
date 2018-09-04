package com.azoraw.spockintro.dependency_injection;

public interface Child {
    Object getSomeObject();
    int getNumberOfToys();
    int getSomeInt();
    void setNumberOfToys(Integer numberOfToys);
    ChildResponse giveToy(Integer numberOfToys);
    boolean getSomeBoolean();
}
