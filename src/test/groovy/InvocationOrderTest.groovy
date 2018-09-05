import com.azoraw.spockintro.dependency_injection.Child
import spock.lang.Specification

class InvocationOrderTest extends Specification{

    def "should give different value each time"(){
        given:
        def child = Mock(Child)
        child.getSomeInt() >>> [1,2,3]

        when:
        def someInt = child.getSomeInt()
        def someInt2 = child.getSomeInt()
        def someInt3 = child.getSomeInt()

        then:
        someInt == 1
        someInt2 == 2
        someInt3 == 3
    }
}
