package delegation

/**
 * Created by chenjinxin on 2020-04-02 11:10
 */

//notNull 适用于那些无法在初始化阶段就确定属性值的场合。
import kotlin.properties.Delegates

class Foo {
    var notNullBar: String by Delegates.notNull<String>()
}

fun main(args: Array<String>) {
    val foo = Foo()
    foo.notNullBar = "bar"
    println(foo.notNullBar)
    //bar
}
//需要注意，如果属性在赋值前就被访问的话则会抛出异常。

/*
局部委托属性
你可以将局部变量声明为委托属性。 例如，你可以使一个局部变量惰性初始化：
 */
/*
fun example(computeFoo: () -> Foo) {
    val memoizedFoo by lazy(computeFoo)

    if (someCondition && memoizedFoo.isValid()) {
        memoizedFoo.doSomething()
    }
}
*/
//memoizedFoo 变量只会在第一次访问时计算。 如果 someCondition 失败，那么该变量根本不会计算。

/** 属性委托要求 **/
/*
对于只读属性(也就是说val属性), 它的委托必须提供一个名为getValue()的函数。该函数接受以下参数：

thisRef —— 必须与属性所有者类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型
property —— 必须是类型 KProperty<*> 或其超类型
这个函数必须返回与属性相同的类型（或其子类型）。

对于一个值可变(mutable)属性(也就是说,var 属性),除 getValue()函数之外,它的委托还必须 另外再提供一个名为setValue()的函数, 这个函数接受以下参数:

property —— 必须是类型 KProperty<*> 或其超类型
new value —— 必须和属性同类型或者是它的超类型。
 */

/** 翻译规则 **/
//在每个委托属性的实现的背后，Kotlin 编译器都会生成辅助属性并委托给它。
// 例如，对于属性 prop，生成隐藏属性 prop$delegate，而访问器的代码只是简单地委托给这个附加属性：
/*
class C {
    var prop: Type by MyDelegate()
}

// 这段是由编译器生成的相应代码：
class C {
    private val prop$delegate = MyDelegate()
    var prop: Type
        get() = prop$delegate.getValue(this, this::prop)
    set(value: Type) = prop$delegate.setValue(this, this::prop, value)
}
        */
//Kotlin 编译器在参数中提供了关于 prop 的所有必要信息：
// 第一个参数 this 引用到外部类 C 的实例而 this::prop 是 KProperty 类型的反射对象，该对象描述 prop 自身。
