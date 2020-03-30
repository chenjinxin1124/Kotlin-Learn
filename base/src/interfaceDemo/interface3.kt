package com.cjx.interfaceDemo

/**
 * @Auther: cjx
 * @Date: 2020/3/30 23:03
 * @Description:
 */

/** 函数重写 **/
// 实现多个接口时，可能会遇到同一方法继承多个实现的问题。例如:
interface A {
    fun foo() { print("A") }   // 已实现
    fun bar()                  // 未实现，没有方法体，是抽象的
}

interface B {
    fun foo() { print("B") }   // 已实现
    fun bar() { print("bar") } // 已实现
}

class C : A {
    override fun bar() { print("bar") }   // 重写
}

class D : A, B {
    override fun foo() {
        super<A>.foo()
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar()
    }
}
/*实例中接口 A 和 B 都定义了方法 foo() 和 bar()， 两者都实现了 foo(), B 实现了 bar()。
因为 C 是一个实现了 A 的具体类，所以必须要重写 bar() 并实现这个抽象方法。

然而，如果我们从 A 和 B 派生 D，我们需要实现多个接口继承的所有方法，并指明 D 应该如何实现它们。
这一规则 既适用于继承单个实现（bar()）的方法也适用于继承多个实现（foo()）的方法。*/
fun main(args: Array<String>) {
    val d =  D()
    d.foo();
    d.bar();
}