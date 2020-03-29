package com.cjx.ClassesAndObjects

/**
 * @Auther: cjx
 * @Date: 2020/3/29 17:34
 * @Description:
 */

/** 主构造器 **/
// 主构造器中不能包含任何代码，初始化代码可以放在初始化代码段中，初始化代码段使用 init 关键字作为前缀。
/*
class Person constructor(firstName: String) {
    init {
        println("FirstName is $firstName")
    }
}*/
// 注意：主构造器的参数可以在初始化代码段中使用，也可以在类主体n定义的属性初始化代码中使用。
// 一种简洁语法，可以通过主构造器来定义属性并初始化属性值（可以是var或val）：
/*class People(val firstName: String, val lastName: String) {
    //...
}*/
// 如果构造器有注解，或者有可见度修饰符，这时constructor关键字是必须的，注解和修饰符要放在它之前。

// 创建一个 Runoob类，并通过构造函数传入网站名：
class Runoob constructor(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }

    fun printTest() {
        println("我是类的函数")
    }
}

fun main(args: Array<String>) {
    val runoob =  Runoob("菜鸟教程")
    println(runoob.siteName)
    println(runoob.url)
    println(runoob.country)
    runoob.printTest()
}