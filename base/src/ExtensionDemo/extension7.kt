package com.cjx.ExtensionDemo

/**
 * @Auther: cjx
 * @Date: 2020/3/31 22:53
 * @Description:
 */

/** 扩展声明为成员 **/
//在一个类内部你可以为另一个类声明扩展。
//
//在这个扩展中，有个多个隐含的接受者，其中扩展方法定义所在类的实例称为分发接受者，而扩展方法的目标类型的实例称为扩展接受者。
class D3 {
    fun bar() { println("D3 bar") }
}

class C3 {
    fun baz() { println("C3 baz") }

    fun D3.foo() {
        bar()   // 调用 D.bar
        baz()   // 调用 C.baz
    }

    fun caller(d3: D3) {
        d3.foo()   // 调用扩展函数
    }
}
//例二
class D4 {
    fun bar() { println("D4 bar") }
}

class C4 {
    fun bar() { println("C4 bar") }  // 与 D 类 的 bar 同名

    fun D4.foo() {
        bar()         // 调用 D.bar()，扩展接收者优先
        this@C4.bar()  // 调用 C.bar()
    }

    fun caller(d4: D4) {
        d4.foo()   // 调用扩展函数
    }
}
//例三
open class D5 {
}

class D6 : D5() {
}

open class C5 {
    open fun D5.foo() {
        println("D5.foo in C5")
    }

    open fun D6.foo() {
        println("D6.foo in C5")
    }

    fun caller(d5: D5) {
        d5.foo()   // 调用扩展函数
    }
}

class C6 : C5() {
    override fun D5.foo() {
        println("D5.foo in C6")
    }

    override fun D6.foo() {
        println("D6.foo in C6")
    }
}

fun main(args: Array<String>) {
    val c3: C3 = C3()
    val d3: D3 = D3()
    c3.caller(d3)
    //D3 bar
    //C3 baz
    //在 C 类内，创建了 D 类的扩展。此时，C 被成为分发接受者，而 D 为扩展接受者。从上例中，可以清楚的看到，在扩展函数中，可以调用派发接收者的成员函数。
    //
    //假如在调用某一个函数，而该函数在分发接受者和扩展接受者均存在，则以扩展接收者优先，要引用分发接收者的成员你可以使用限定的 this 语法。
    val c4: C4 = C4()
    val d4: D4 = D4()
    c4.caller(d4)
    //D4 bar
    //C4 bar
    //以成员的形式定义的扩展函数, 可以声明为 open , 而且可以在子类中覆盖.
    //也就是说, 在这类扩展函数的派 发过程中, 针对分发接受者是虚拟的(virtual), 但针对扩展接受者仍然是静态的。
    C5().caller(D5())   // 输出 "D.foo in C"
    C6().caller(D5())  // 输出 "D.foo in C1" —— 分发接收者虚拟解析
    C5().caller(D6())  // 输出 "D.foo in C" —— 扩展接收者静态解析
}

