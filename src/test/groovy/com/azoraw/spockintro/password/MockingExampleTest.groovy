package com.azoraw.spockintro.password

import com.azoraw.spockintro.dependency_injection.Child
import com.azoraw.spockintro.dependency_injection.ChildResponse
import com.azoraw.spockintro.dependency_injection.Parent
import spock.lang.Specification

class MockingExampleTest extends Specification {

    def childMock = Mock(Child)

    def "mock test"() {
        expect:
        childMock.getSomeInt() == 0
        childMock.getSomeObject() == null

        childMock.getSomeBoolean() == false
        !childMock.getSomeBoolean()           //simpler but is it clearer?
    }

    def "mock usage test"() {                 //spring DI
        given:
        def parent = new Parent(childMock)

        when:
        parent.giveChildAToy()

        then:
        1 * childMock.setNumberOfToys(1)
    }

    def "specific mock test"() {
        given:
        def specificMock = Mock(Child) {
            giveToy(1) >> Mock(ChildResponse) {
                childMsg = 'Thank you!'
            }
        }

        def parent = new Parent(specificMock)

        when:
        def childResponse = parent.giveChildAToy()

        then:
        childResponse == 'Thank you!'


    }
}
