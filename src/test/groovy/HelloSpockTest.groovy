import spock.lang.Specification

class HelloSpockTest extends Specification {

    def "example test"() {
        given:
        def i = 1

        when:
        i++

        then:
        i == 2
    }

}
