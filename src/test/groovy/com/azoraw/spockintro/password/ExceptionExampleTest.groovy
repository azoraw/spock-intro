package com.azoraw.spockintro.password

import spock.lang.Specification

class ExceptionExampleTest extends Specification {

    def "throwing exception example"() {
        given:
        def passwordValidator = new PasswordService()

        when:
        passwordValidator.savePassword('abc')

        then:
        def exception = thrown(IllegalArgumentException)
        exception.message == 'password is weak'
    }
}
