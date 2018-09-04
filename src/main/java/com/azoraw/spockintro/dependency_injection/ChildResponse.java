package com.azoraw.spockintro.dependency_injection;

public class ChildResponse {

    private String childMsg;

    public ChildResponse(String childMsg) {
        this.childMsg = childMsg;
    }

    public String getChildMsg() {
        return childMsg;
    }

}
