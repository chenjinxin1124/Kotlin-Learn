package com.cjx.ExtensionDemo

//import kotlin.reflect.typeOf

/**
 * @Auther: cjx
 * @Date: 2020/3/31 22:36
 * @Description:
 */
/** 扩展一个空对象 **/
// 在扩展函数内， 可以通过 this 来判断接收者是否为 NULL,这样，即使接收者为 NULL,也可以调用扩展函数。例如:
fun Any?.toString(): String {
    if (this == null) return "null"
    // 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}
fun main(arg:Array<String>){
    var t = null
    println(t.toString()) //null
}