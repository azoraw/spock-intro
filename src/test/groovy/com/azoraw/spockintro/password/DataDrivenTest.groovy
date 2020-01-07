package com.azoraw.spockintro.password

import spock.lang.Specification
import spock.lang.Unroll

class DataDrivenTest extends Specification {

    @Unroll
    def "check regex if #password is #weak"() {
        given:
        def passwordService = new PasswordService()

        expect:
        passwordService.isWeak(password) == weak

        where:
        password      | weak
        '123456Aa!'   | true
        '12345678a!'  | true
        '12345678A!'  | true
        'AAAAbbbb!'   | true
        '1234567Aa~'  | false
        '1234567Aa!'  | false
        '1234567Aa@'  | false
        '1234567Aa#'  | false
        '1234567Aa$'  | false
        '1234567Aa%'  | false
        '1234567Aa^'  | false
        '1234567Aa&'  | false
        '1234567Aa*'  | false
        '1234567Aa('  | false
        '1234567Aa)'  | false
        '1234567Aa_'  | false
        '1234567Aa-'  | false
        '1234567Aa+'  | false
        '1234567Aa='  | false
        '1234567Aa{'  | false
        '1234567Aa}'  | false
        '1234567Aa['  | false
        '1234567Aa]'  | false
        '1234567Aa\\' | false
        '1234567Aa|'  | false
        '1234567Aa;'  | false
        '1234567Aa:'  | false
        '1234567Aa\'' | false
        '1234567Aa"'  | false
        '1234567Aa<'  | false
        '1234567Aa>'  | false
        '1234567Aa,'  | false
        '1234567Aa.'  | false
        '1234567Aa?'  | false
        '1234567Aa/'  | false
        '1234567Aa`'  | false
    }

    @Unroll
    def "#a + #b equals #result"() {
        expect:
        sum(a, b) == result

        where:
        a   | b || result
        1   | 2 || 3
        123 | 2 || 125

    }

    def sum(def a, def b) {
        a + b
    }

}
