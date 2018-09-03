import spock.lang.Specification

class BasicInfoTest extends Specification {

    def "you can have comments wherever you want"() {
        given: "some integer"
        def i = 1

        when: "we increment"
        i++

        then: "it should have higher value"
        i == 2
    }

    def "expect block example"() {
        /*when:
        def x = Math.max(1, 2)

        then:
        x == 2*/

        expect:                 //PRO TIP: use for functional methods
        Math.max(1, 2) == 2
    }


}
