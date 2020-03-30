package com.cjx.inheritDemo

/**
 * @Auther: cjx
 * @Date: 2020/3/30 22:07
 * @Description:
 */

/** 属性重写 **/
// 属性重写使用 override 关键字，属性必须具有兼容类型，每一个声明的属性都可以通过初始化程序或者getter方法被重写：
/*
open class Foo {
    open val x: Int get { …… }
}

class Bar1 : Foo() {
    override val x: Int = ……
}*/

// 你可以用一个var属性重写一个val属性，但是反过来不行。因为val属性本身定义了getter方法，重写为var属性会在衍生类中额外声明一个setter方法

//你可以在主构造函数中使用 override 关键字作为属性声明的一部分:
interface Foo {
    val count: Int
}

class Bar1(override val count: Int) : Foo

class Bar2 : Foo {
    override var count: Int = 0
}
