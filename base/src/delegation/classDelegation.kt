package delegation

/**
 * Created by chenjinxin on 2020-04-02 10:32
 */
/*
委托模式是软件设计模式中的一项基本技巧。在委托模式中，有两个对象参与处理同一个请求，
接受请求的对象将请求委托给另一个对象来处理。

Kotlin 直接支持委托模式，更加优雅，简洁。Kotlin 通过关键字 by 实现委托。
 */
/*
类委托
类的委托即一个类中定义的方法实际是调用另一个类的对象的方法来实现的。

以下实例中派生类 Derived 继承了接口 Base 所有方法，并且委托一个传入的 Base 类的对象来执行这些方法。
 */
// 创建接口
interface Base {
    fun print()
}

// 实现此接口的被委托的类
class BaseImpl(val x: Int) : Base {
    override fun print() { print(x) }
}

// 通过关键字 by 建立委托类
class Derived(b: Base) : Base by b

fun main(args: Array<String>) {
    val b = BaseImpl(10)
    Derived(b).print() // 输出 10
}
//在 Derived 声明中，by 子句表示，将 b 保存在 Derived 的对象实例内部，
// 而且编译器将会生成继承自 Base 接口的所有方法, 并将调用转发给 b。