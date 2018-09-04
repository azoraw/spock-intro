package com.azoraw.spockintro.dependency_injection;

public interface Child {
    Object getSomeObject();
    int getSomeInt();
    boolean getSomeBoolean();

    int getNumberOfToys();
    void setNumberOfToys(Integer numberOfToys);
    ChildResponse playWithToys(Integer numberOfToys);
}
