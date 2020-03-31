package com.cjx.ExtensionDemo

/**
 * @Auther: cjx
 * @Date: 2020/3/31 22:50
 * @Description:
 */

/** 扩展的作用域 **/
//通常扩展函数或属性定义在顶级包下:
//package foo.bar
//
//class Baz
//
//fun Baz.goo() {
//    println("扩展的作用域")
//}
//要使用所定义包之外的一个扩展, 通过import导入扩展的函数名进行使用:
//package com.example.usage
//
//import foo.bar.goo // 导入所有名为 goo 的扩展
// 或者
//import foo.bar.*   // 从 foo.bar 导入一切
//
//fun usage(baz: Baz) {
//    baz.goo()
//}