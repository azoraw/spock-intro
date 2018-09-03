package com.azoraw.spockintro.password

import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenTest extends Specification {

    @Unroll
    def "check regex if #password is #strong"() {
        given:
        def passwordValidator = new Password()

        expect:
        passwordValidator.isPasswordStrong(password) == strong

        where:
        password      | strong
        '123456Aa!'   | false
        '12345678a!'  | false
        '12345678A!'  | false
        'AAAAbbbb!'   | false
        '1234567Aa~'  | true
        '1234567Aa!'  | true
        '1234567Aa@'  | true
        '1234567Aa#'  | true
        '1234567Aa\$' | true
        '1234567Aa%'  | true
        '1234567Aa^'  | true
        '1234567Aa&'  | true
        '1234567Aa*'  | true
        '1234567Aa('  | true
        '1234567Aa)'  | true
        '1234567Aa_'  | true
        '1234567Aa-'  | true
        '1234567Aa+'  | true
        '1234567Aa='  | true
        '1234567Aa{'  | true
        '1234567Aa}'  | true
        '1234567Aa['  | true
        '1234567Aa]'  | true
        '1234567Aa\\' | true
        '1234567Aa|'  | true
        '1234567Aa;'  | true
        '1234567Aa:'  | true
        '1234567Aa\'' | true
        '1234567Aa"'  | true
        '1234567Aa<'  | true
        '1234567Aa>'  | true
        '1234567Aa,'  | true
        '1234567Aa.'  | true
        '1234567Aa?'  | true
        '1234567Aa/'  | true
        '1234567Aa`'  | true
    }
}
