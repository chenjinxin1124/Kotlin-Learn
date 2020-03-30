package com.cjx.interfaceDemo

/**
 * @Auther: cjx
 * @Date: 2020/3/30 22:59
 * @Description:
 */

/** 接口 **/
// Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：
interface MyInterface {
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}
// 实现接口
// 一个类或者对象可以实现一个或多个接口。
class Child : MyInterface {
    override fun bar() {
        // 方法体
        println("bar")
    }
}
fun main(args: Array<String>) {
    val c =  Child()
    c.foo();
    c.bar();

}