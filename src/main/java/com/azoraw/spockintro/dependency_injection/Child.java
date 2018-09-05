package com.azoraw.spockintro.dependency_injection;

public interface Child {
    Object getSomeObject();
    int getSomeInt();
    boolean getSomeBoolean();

    void sleep();
    Toy getToy(String toyType);
}
