package com.azoraw.spockintro.password;

public class Password {

    private static final String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\\\\]).{10," +
        "}$";          //very secure password


    public void savePassword(String passsword) {

        if(isPasswordStrong(passsword)) {
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
