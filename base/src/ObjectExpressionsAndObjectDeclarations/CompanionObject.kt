package ObjectExpressionsAndObjectDeclarations

/**
 * @Auther: cjx
 * @Date: 2020/4/1 23:56
 * @Description:
 */

/** 伴生对象 **/
//类内部的对象声明可以用 companion 关键字标记，这样它就与外部类关联在一起，我们就可以直接通过外部类访问到对象的内部元素。
class MyClass {
    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}
//我们可以省略掉该对象的对象名，然后使用 Companion 替代需要声明的对象名：
class MyClass2 {
    companion object {
    }
}
//注意：一个类里面只能声明一个内部关联对象，即关键字 companion 只能使用一次。
//
//伴生对象的成员看起来像其他语言的静态成员，但在运行时他们仍然是真实对象的实例成员。例如还可以实现接口：
interface Factory<T> {
    fun create(): T
}


class MyClass3 {
    companion object : Factory<MyClass> {
        override fun create(): MyClass = MyClass()
    }
}

fun main() {
    val instance = MyClass.create()   // 访问到对象的内部元素
    println(instance)
    val x = MyClass2.Companion
    println(x)
}

//对象表达式和对象声明之间的语义差异
/*
对象表达式和对象声明之间有一个重要的语义差别：

对象表达式是在使用他们的地方立即执行的
对象声明是在第一次被访问到时延迟初始化的
伴生对象的初始化是在相应的类被加载（解析）时，与 Java 静态初始化器的语义相匹配
 */