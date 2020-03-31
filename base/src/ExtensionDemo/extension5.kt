package com.cjx.ExtensionDemo

/**
 * @Auther: cjx
 * @Date: 2020/3/31 22:44
 * @Description:
 */

/** 伴生对象的扩展 **/
//如果一个类定义有一个伴生对象 ，你也可以为伴生对象定义扩展函数和属性。
//
//伴生对象通过"类名."形式调用伴生对象，伴生对象声明的扩展函数，通过用类名限定符来调用：
class MyClass {
    companion object { }  // 将被称为 "Companion"
}

fun MyClass.Companion.foo() {
    println("伴随对象的扩展函数")
}

val MyClass.Companion.no: Int
    get() = 10

fun main(args: Array<String>) {
    println("no:${MyClass.no}")
    MyClass.foo()
    //no:10
    //伴随对象的扩展函数
}