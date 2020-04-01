package GenericDemo

/**
 * Created by chenjinxin on 2020-04-01 17:20
 */

//Kotlin 泛型函数的声明与 Java 相同，类型参数要放在函数名的前面：
/*
fun <T> boxIn(value: T) = Box(value)

// 以下都是合法语句
val box4 = boxIn<Int>(1)
val box5 = boxIn(1)     // 编译器会进行类型推断
 */

//在调用泛型函数时，如果可以推断出类型参数，可以省略泛型参数。
//以下实例创建了泛型函数 doPrintln，函数根据传入的不同类型做相应处理：
fun main(args: Array<String>) {
    val age = 23
    val name = "runoob"
    val bool = true

    doPrintln(age)    // 整型
    doPrintln(name)   // 字符串
    doPrintln(bool)   // 布尔型
    //整型数字为 23
    //字符串转换为大写：RUNOOB
    //T 不是整型，也不是字符串
}

fun <T> doPrintln(content: T) {

    when (content) {
        is Int -> println("整型数字为 $content")
        is String -> println("字符串转换为大写：${content.toUpperCase()}")
        else -> println("T 不是整型，也不是字符串")
    }
}

//泛型约束
/*
我们可以使用泛型约束来设定一个给定参数允许使用的类型。
Kotlin 中使用 : 对泛型的类型上限进行约束。
最常见的约束是上界(upper bound)：

fun <T : Comparable<T>> sort(list: List<T>) {
    // ……
}

Comparable 的子类型可以替代 T。 例如:

sort(listOf(1, 2, 3)) // OK。Int 是 Comparable<Int> 的子类型
sort(listOf(HashMap<Int, String>())) // 错误：HashMap<Int, String> 不是 Comparable<HashMap<Int, String>> 的子类型

默认的上界是 Any?。
对于多个上界约束条件，可以用 where 子句：

fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
    where T : CharSequence,
          T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}
 */
