package com.azoraw.spockintro.dependency_injection;

public class Toy {

    private String name;

    public Toy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
