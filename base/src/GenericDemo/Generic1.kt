package GenericDemo

/**
 * Created by chenjinxin on 2020-04-01 17:16
 */

/** 泛型 **/
//泛型，即 "参数化类型"，将类型参数化，可以用在类，接口，方法上。
//与 Java 一样，Kotlin 也提供泛型，为类型安全提供保证，消除类型强转的烦恼。
//声明一个泛型类:
/*
class Box<T>(t: T) {
    var value = t
}
 */
//创建类的实例时我们需要指定类型参数:
/*
val box: Box<Int> = Box<Int>(1)
// 或者
val box = Box(1) // 编译器会进行类型推断，1 类型 Int，所以编译器知道我们说的是 Box<Int>。
 */

//以下实例向泛型类 Box 传入整型数据和字符串：
class Box<T>(t : T) {
    var value = t
}

fun main(args: Array<String>) {
    //定义泛型类型变量，可以完整地写明类型参数，如果编译器可以自动推定类型参数，也可以省略类型参数。
    var boxInt = Box<Int>(10)
    var boxString = Box<String>("Runoob")

    println(boxInt.value)
    println(boxString.value)
    //10
    //Runoob
}