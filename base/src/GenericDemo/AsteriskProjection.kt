package GenericDemo

/**
 * @Auther: cjx
 * @Date: 2020/4/1 21:44
 * @Description:
 */

/** 星号投射 **/
/*
有些时候, 你可能想表示你并不知道类型参数的任何信息, 但是仍然希望能够安全地使用它.
这里所谓"安全地使用"是指, 对泛型类型定义一个类型投射, 要求这个泛型类型的所有的实体实例, 都是这个投射的子类型。

对于这个问题, Kotlin 提供了一种语法, 称为 星号投射(star-projection):

假如类型定义为 Foo<out T> , 其中 T 是一个协变的类型参数, 上界(upper bound)为 TUpper ,Foo<> 等价于 Foo<out TUpper> .
它表示, 当 T 未知时, 你可以安全地从 Foo<> 中 读取TUpper 类型的值.
假如类型定义为 Foo<in T> , 其中 T 是一个反向协变的类型参数, Foo<> 等价于 Foo<inNothing> .
它表示, 当 T 未知时, 你不能安全地向 Foo<> 写入 任何东西.
假如类型定义为 Foo<T> , 其中 T 是一个协变的类型参数, 上界(upper bound)为 TUpper ,
对于读取值的场合, Foo<*> 等价于 Foo<out TUpper> ,
对于写入值的场合, 等价于 Foo<in Nothing> .
如果一个泛型类型中存在多个类型参数, 那么每个类型参数都可以单独的投射.
比如, 如果类型定义为interface Function<in T, out U> , 那么可以出现以下几种星号投射:

Function<*, String> , 代表 Function<in Nothing, String> ;
Function<Int, *> , 代表 Function<Int, out Any?> ;
Function<, > , 代表 Function<in Nothing, out Any?> .
注意: 星号投射与 Java 的原生类型(raw type)非常类似, 但可以安全使用
 */

/*
关于星号投射，其实就是*代指了所有类型，相当于Any?

给文中补个例子方便理解：
 */
class A<T>(val t: T, val t2 : T, val t3 : T)
class Apple(var name : String)
fun main(args: Array<String>) {
    //使用类
    val a1: A<*> = A(12, "String", Apple("苹果"))
    val a2: A<Any?> = A(12, "String", Apple("苹果"))   //和a1是一样的
    val apple = a1.t3    //参数类型为Any
    println(apple)
    val apple2 = apple as Apple   //强转成Apple类
    println(apple2.name)
    //使用数组
    val l:ArrayList<*> = arrayListOf("String",1,1.2f,Apple("苹果"))
    for (item in l){
        println(item)
    }
}