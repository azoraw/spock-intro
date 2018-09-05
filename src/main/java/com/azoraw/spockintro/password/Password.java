package com.azoraw.spockintro.password;

public class Password {

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\\\\]).{10," +
        "}$";          //very secure password: minimum 10 chars, 1 upper, 1 lower, 1 special, 1 number


    public void savePassword(String password) {

        if(isPasswordStrong(password)) {
            //save password
        }
        else {
            //throw exception
        }
    }


    private boolean isPasswordStrong(String password) {
       return password.matches(PASSWORD_REGEX);
    }


}
