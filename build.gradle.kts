import test.A
import test.TestTask

val aInstance: A = objects.newInstance<A>()

tasks.register<TestTask>("myTask") {
    b = aInstance.b
}
