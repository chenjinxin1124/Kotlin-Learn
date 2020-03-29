package com.cjx.ClassesAndObjects

/**
 * @Auther: cjx
 * @Date: 2020/3/29 21:01
 * @Description:
 */

/*
内部类
内部类使用 inner 关键字来表示。

内部类会带有一个对外部类的对象的引用，所以内部类可以访问外部类成员属性和成员函数。*/
class Outer2 {
    private val bar: Int = 1
    var v = "成员属性"
    /**嵌套内部类**/
    inner class Inner {
        fun foo() = bar  // 访问外部类成员
        fun innerTest() {
            // 为了消除歧义，要访问来自外部作用域的 this，我们使用this@label，其中 @label 是一个 代指 this 来源的标签。
            var o = this@Outer2 //获取外部类的成员变量
            println("内部类可以引用外部类的成员，例如：" + o.v)
        }
    }
}

fun main(args: Array<String>) {
    val demo = Outer2().Inner().foo()
    println(demo) //   1
    val demo2 = Outer2().Inner().innerTest()
    println(demo2)   // 内部类可以引用外部类的成员，例如：成员属性
}
