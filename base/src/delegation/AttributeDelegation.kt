package delegation

/**
 * Created by chenjinxin on 2020-04-02 10:37
 */
/** 属性委托 **/
//属性委托指的是一个类的某个属性值不是在类中直接进行定义，而是将其托付给一个代理类，从而实现对该类的属性统一管理。
//
//属性委托语法格式：
//val/var <属性名>: <类型> by <表达式>
/*
var/val：属性类型(可变/只读)
属性名：属性名称
类型：属性的数据类型
表达式：委托代理类
 */
//by 关键字之后的表达式就是委托, 属性的 get() 方法(以及set() 方法)将被委托给这个对象的 getValue() 和 setValue() 方法。
// 属性委托不必实现任何接口, 但必须提供 getValue() 函数(对于 var属性,还需要 setValue() 函数)。

/*
定义一个被委托的类
该类需要包含 getValue() 方法和 setValue() 方法，且参数 thisRef 为进行委托的类的对象，prop 为进行委托的属性的对象。
 */
import kotlin.reflect.KProperty
// 定义包含属性委托的类
class Example {
    var p: String by Delegate()
}

// 委托的类
class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, 这里委托了 ${property.name} 属性"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$thisRef 的 ${property.name} 属性赋值为 $value")
    }
}
fun main(args: Array<String>) {
    val e = Example()
    println(e.p)     // 访问该属性，调用 getValue() 函数

    e.p = "Runoob"   // 调用 setValue() 函数
    println(e.p)
    //delegation.Example@2e817b38, 这里委托了 p 属性
    //delegation.Example@2e817b38 的 p 属性赋值为 Runoob
    //delegation.Example@2e817b38, 这里委托了 p 属性
}