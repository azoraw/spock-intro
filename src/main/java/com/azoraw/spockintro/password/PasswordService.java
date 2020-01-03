package com.azoraw.spockintro.password;

public class PasswordService {

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\\\\]).{10," +
            "}$";          //very secure password: minimum 10 chars, 1 upper, 1 lower, 1 special, 1 number


    public void savePassword(String password) {

        if (isPasswordWeak(password)) {
            throw new IllegalArgumentException("password is weak");
        }
        //save password
    }


    private boolean isPasswordWeak(String password) {
        return !password.matches(PASSWORD_REGEX);
    }


}
