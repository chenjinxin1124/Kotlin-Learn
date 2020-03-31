package com.cjx.ExtensionDemo

/**
 * @Auther: cjx
 * @Date: 2020/3/31 22:31
 * @Description:
 */
/** 扩展函数是静态解析的 **/
// 扩展函数是静态解析的，并不是接收者类型的虚拟成员，在调用扩展函数时，
// 具体被调用的的是哪一个函数，由调用函数的的对象表达式来决定的，而不是动态的类型决定的:
open class C

class D : C()

fun C.foo() = "c"   // 扩展函数 foo

fun D.foo() = "d"   // 扩展函数 foo

fun printFoo(c: C) {
    println(c.foo())  // 类型是 C 类
}

// 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
class C2 {
    fun foo() {
        println("成员函数")
    }
}

fun C2.foo() {
    println("扩展函数")
}

fun main(arg: Array<String>) {
    printFoo(D()) // c
    // 若扩展函数和成员函数一致，则使用该函数时，会优先使用成员函数。
    var c = C2()
    c.foo() // 成员函数
}
//扩展属性
//除了函数，Kotlin 也支持属性对属性进行扩展:
/* val <T> List<T>.lastIndex: Int
    get() = size - 1 */
//扩展属性允许定义在类或者kotlin文件中，不允许定义在函数中。
//初始化属性因为属性没有后端字段（backing field），所以不允许被初始化，只能由显式提供的 getter/setter 定义。
//val Foo.bar = 1 // 错误：扩展属性不能有初始化器
//扩展属性只能被声明为 val。