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
        parent.readChildABook()

        then:
        1 * childMock.sleep()

        //cardinality:
        /*
         0 * childMock.sleep()
         1 * childMock.sleep()
         (1..3) * childMock.sleep()
         (1.._) * childMock.sleep()
         (_..3) * childMock.sleep()
         _ * childMock.sleep()  //any number, including 0. WHAT IS IT FOR?!?
         */
    }

    def "specific mock test"() {
        given:
        def specificMock = Mock(Child) {
            getToy('teddy bear') >> new Toy('Winnie the Pooh')
            getToy('monster truck') >> Mock(Toy) {
                getName() >> 'Wroooom Wroooom'
            }
            getToy(*_) >> {                               //wildcards: _, !null, _ as Integer,
                String toyType ->                         //GROOVY CLOSURE
                    Mock(Toy) {
                        getName() >> toyType
                    }
            }
        }

        def parent = new Parent(specificMock)

        when:
        def childResponse = parent.getToyName('teddy bear')
        def childResponse2 = parent.getToyName('monster truck')
        def childResponse3 = parent.getToyName('action figure')

        then:
        childResponse
        childResponse == 'Winnie the Pooh'
        childResponse2 == 'Wroooom Wroooom'
        childResponse3 == 'action figure'
    }

}
