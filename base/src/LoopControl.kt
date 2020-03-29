package com.cjx

/**
 * @Auther: cjx
 * @Date: 2020/3/29 16:09
 * @Description:
 */

/** For 循环 **/
fun forLoop() {
    // for 循环可以对任何提供迭代器（iterator）的对象进行遍历，语法如下:
    // for (item in collection) print(item)
    // 循环体可以是一个代码块:
    // for (item: Int in ints) {
    //    // ……
    //}

    // for 可以循环遍历任何提供了迭代器的对象。

    // 对集合进行迭代：
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println(item)
    }

    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    // 对数组进行迭代：
    val arr = arrayOf("apple", "banana", "kiwi")
    for (a in arr) {
        println(a)
    }

    for (a in arr.indices) {
        println("item at $a is ${arr[a]}")
    }

    // 这种"在区间上遍历"会编译成优化的实现而不会创建额外对象。
    // 用库函数 withIndex：
    for ((index, value) in arr.withIndex()) {
        println("the element at $index is $value")
    }
}

/** while 与 do...while 循环 **/
fun whileDoWhile() {
    println("----while 使用-----")
    var x = 5
    while (x > 0) {
        println(x--)
    }
    println("----do...while 使用-----")
    var y = 5
    do {
        println(y--)
    } while (y > 0)
}

/** 返回和跳转 **/
fun BackAndJump() {
    /*Kotlin 有三种结构化跳转表达式：
    return。默认从最直接包围它的函数或者匿名函数返回。
    break。终止最直接包围它的循环。
    continue。继续下一次最直接包围它的循环。*/
    // 在循环中 Kotlin 支持传统的 break 和 continue 操作符。
    println("----continue break 使用-----")
    for (i in 1..10) {
        if (i == 3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        println(i)
        if (i > 5) break   // i 为 6 时 跳出循环
    }

    // Break 和 Continue 标签
    // 在 Kotlin 中任何表达式都可以用标签（label）来标记。 标签的格式为标识符后跟 @ 符号，
    // 例如：abc@、fooBar@都是有效的标签。 要为一个表达式加标签，我们只要在其前加标签即可。
    println("----标签 使用-----")
    loop@ for (i in 1..10) {
        if (i % 2 == 0) break@loop
        else println(i)
    }
    loop@ for (i in 1..10) {
        if (i % 2 == 0) break
        else println(i)
    }
}

/** 标签处返回 **/
fun ReturnAtLabel(){
    // Kotlin 有函数字面量、局部函数和对象表达式。因此 Kotlin 的函数可以被嵌套。
    // 标签限制的 return 允许我们从外层函数返回。 最重要的一个用途就是从 lambda 表达式中返回。回想一下我们这么写的时候：
    println("----return 使用-----")
    fun foo(ints: IntArray) {
        ints.forEach {
            if (it == 2) return
            println(it)
        }
    }
    // 这个 return 表达式从最直接包围它的函数即 foo 中返回。 （注意，这种非局部的返回只支持传给内联函数的 lambda 表达式。）
    // 如果我们需要从 lambda 表达式中返回，我们必须给它加标签并用以限制 return。
    println("----lit@ 使用-----")
    fun foo2(ints: IntArray) {
        ints.forEach lit@ {
            if (it == 2) return@lit
            println(it)
        }
    }
    // 现在，它只会从 lambda 表达式中返回。通常情况下使用隐式标签更方便。 该标签与接受该 lambda 的函数同名。
    println("----隐式标签 使用-----")
    fun foo3(ints: IntArray) {
        ints.forEach {
            if (it == 2) return@forEach
            println(it)
        }
    }
    // 或者，我们用一个匿名函数替代 lambda 表达式。 匿名函数内部的 return 语句将从该匿名函数自身返回
    fun foo4(ints: IntArray) {
        ints.forEach(fun(value: Int) {
            if (value == 2) return
            println(value)
        })
    }
    val ints = intArrayOf(1,2,3)
    // foo(ints)
    // foo2(ints)
    // foo3(ints)
    foo4(ints)

}

fun main() {
//    forLoop()
//    whileDoWhile()
//    BackAndJump()
    ReturnAtLabel()
}