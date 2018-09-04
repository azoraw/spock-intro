package com.azoraw.spockintro.dependency_injection;

public class ChildImpl implements Child {

    private static final int exampleField = 100;

    @Override
    public Object getSomeObject() {
        return null;
    }

    @Override
    public int getNumberOfToys() {
        return 0;
    }

    @Override
    public int getSomeInt() {
        return 0;
    }

    @Override
    public void setNumberOfToys(Integer numberOfToys) {

    }

    @Override
    public ChildResponse giveToy(Integer numberOfToys) {
        return null;
    }

    @Override
    public boolean getSomeBoolean() {
        return false;
    }

    //many complicated methods here (in the meaning a lot of dependency)

}
