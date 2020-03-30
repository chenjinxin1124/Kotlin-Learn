package com.cjx.interfaceDemo

/**
 * @Auther: cjx
 * @Date: 2020/3/30 23:02
 * @Description:
 */

/** 接口中的属性 **/
// 接口中的属性只能是抽象的，不允许初始化值，接口不会保存属性值，实现接口时，必须重写属性：
interface MyInterface2 {
    var name:String //name 属性, 抽象的
    fun bar()
    fun foo() {
        // 可选的方法体
        println("foo")
    }
}
class Child2 : MyInterface2 {
    override var name: String = "runoob" //重写属性
    override fun bar() {
        // 方法体
        println("bar")
    }
}
fun main(args: Array<String>) {
    val c =  Child2()
    c.foo();
    c.bar();
    println(c.name)

}