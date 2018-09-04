package com.azoraw.spockintro.dependency_injection

import spock.lang.Specification

class MockingExampleTest extends Specification {

    def childMock = Mock(Child)
    //Child childMock = Mock()   //also works

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
            playWithToys(1) >> new ChildResponse('Thank you!')
            playWithToys(10) >> Mock(ChildResponse) {
                getChildMsg() >> 'WOOOOW'
            }
            playWithToys(*_) >> {                               //wildcards: _, !null, _ as Integer,
                Integer numberOfToys ->                         //GROOVY CLOSURE
                    Mock(ChildResponse) {
                        getChildMsg() >> 'thanks for ' + numberOfToys + ' toys'
                    }
            }
        }

        def parent = new Parent(specificMock)

        when:
        def childResponse = parent.giveChildAToysAndSeeResponse(1)
        def childResponse2 = parent.giveChildAToysAndSeeResponse(10)
        def childResponse3 = parent.giveChildAToysAndSeeResponse(7)

        then:
        childResponse
        childResponse == 'Thank you!'
        childResponse2 == 'WOOOOW'
        childResponse3 == 'thanks for 7 toys'
    }

    def "throwing exception example"() {
        given:
        childMock.getSomeObject() >> {
            throw new IllegalStateException('no object for you')
        }

        when:
        childMock.getSomeObject()

        then:
        def exception = thrown(IllegalStateException)
        exception.message == 'no object for you'
    }
}
