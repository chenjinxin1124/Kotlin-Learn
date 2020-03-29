package com.cjx.ClassesAndObjects

/**
 * @Auther: cjx
 * @Date: 2020/3/29 20:58
 * @Description:
 */
/*
抽象类
抽象是面向对象编程的特征之一，类本身，或类中的部分成员，都可以声明为abstract的。抽象成员在类中不存在具体的实现。

注意：无需对抽象类或抽象成员标注open注解。*/
/*open class Base {
    open fun f() {}
}

abstract class Derived : Base() {
    override abstract fun f()
}*/

/*嵌套类
我们可以把类嵌套在其他类中，看以下实例：*/
class Outer {                  // 外部类
    private val bar: Int = 1
    class Nested {             // 嵌套类
        fun foo() = 2
    }
}

fun main(args: Array<String>) {
    val demo = Outer.Nested().foo() // 调用格式：外部类.嵌套类.嵌套类方法/属性
    println(demo)    // == 2
}
