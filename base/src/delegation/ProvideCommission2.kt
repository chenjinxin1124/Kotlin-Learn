package delegation

/**
 * Created by chenjinxin on 2020-04-02 11:56
 */
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty
class MyReadOnlyPropertyImpl : ReadOnlyProperty<MyTestClass, String> {
    override fun getValue(thisRef: MyTestClass, property: KProperty<*>): String {
        val s  = "aaa"
        return s;
    }
}
class MyProvider {
    operator fun provideDelegate(thisRef: MyTestClass, prop: KProperty<*>): ReadOnlyProperty<MyTestClass, String> {
        println("do something") // 这行代码是在getValue方法之外调用的
        val myReadOnlyPropertyImpl = MyReadOnlyPropertyImpl() // 这里才是调用getValue方法的地方
        return myReadOnlyPropertyImpl
    }
}
class MyTestClass {
    val myProvider = MyProvider()
    val myField1: String by myProvider
}
// 测试
fun main(args: Array<String>) {
    val myTestClass = MyTestClass()
    println(myTestClass.myField1)
    //do something
    //aaa
}