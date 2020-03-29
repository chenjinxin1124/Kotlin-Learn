package com.cjx.ClassesAndObjects

/**
 * @Auther: cjx
 * @Date: 2020/3/29 20:54
 * @Description:
 */

class Runoob2  constructor(name: String) {  // 类名为 Runoob
    // 大括号内是类体构成
    var url: String = "http://www.runoob.com"
    var country: String = "CN"
    var siteName = name

    init {
        println("初始化网站名: ${name}")
    }
    // 类也可以有二级构造函数，需要加前缀 constructor:
    // 次构造函数
    // 如果类有主构造函数，每个次构造函数都要，或直接或间接通过另一个次构造函数代理主构造函数。
    // 在同一个类中代理另一个构造函数使用 this 关键字：
    constructor (name: String, alexa: Int) : this(name) {
        println("Alexa 排名 $alexa")
    }
    // 如果一个非抽象类没有声明构造函数(主构造函数或次构造函数)，它会产生一个没有参数的构造函数。
    // 构造函数是 public 。如果你不想你的类有公共的构造函数，你就得声明一个空的主构造函数：
    // 注意：在 JVM 虚拟机中，如果主构造函数的所有参数都有默认值，编译器会生成一个附加的无参的构造函数，这个构造函数会直接使用默认值。
    // 这使得 Kotlin 可以更简单的使用像 Jackson 或者 JPA 这样使用无参构造函数来创建类实例的库。
    fun printTest() {
        println("我是类的函数")
    }
}

fun main(args: Array<String>) {
    val runoob =  Runoob2("菜鸟教程", 10000)
    println(runoob.siteName)
    println(runoob.url)
    println(runoob.country)
    runoob.printTest()
}