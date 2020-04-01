package ObjectExpressionsAndObjectDeclarations

/**
 * @Auther: cjx
 * @Date: 2020/4/1 23:21
 * @Description:
 */

//Kotlin 用对象表达式和对象声明来实现创建一个对某个类做了轻微改动的类的对象，且不需要去声明一个新的子类。
/** 对象表达式 **/
//通过对象表达式实现一个匿名内部类的对象用于方法的参数中：
/*
window.addMouseListener(object : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) {
        // ...
    }
    override fun mouseEntered(e: MouseEvent) {
        // ...
    }
})
 */
//对象可以继承于某个基类，或者实现其他接口:
/*
open class A(x: Int) {
    public open val y: Int = x
}

interface B {……}

val ab: A = object : A(1), B {
    override val y = 15
}
 */
//如果超类型有一个构造函数，则必须传递参数给它。多个超类型和接口可以用逗号分隔。
//通过对象表达式可以越过类的定义直接得到一个对象：
fun main(args: Array<String>) {
    val site = object {
        var name: String = "菜鸟教程"
        var url: String = "www.runoob.com"
    }
    println(site.name)
    println(site.url)
}
//请注意，匿名对象可以用作只在本地和私有作用域中声明的类型。
// 如果你使用匿名对象作为公有函数的 返回类型或者用作公有属性的类型，那么该函数或属性的实际类型 会是匿名对象声明的超类型，
// 如果你没有声明任何超类型，就会是 Any。在匿名对象 中添加的成员将无法访问。
/*
class C {
    // 私有函数，所以其返回类型是匿名对象类型
    private fun foo() = object {
        val x: String = "x"
    }

    // 公有函数，所以其返回类型是 Any
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x        // 没问题
        val x2 = publicFoo().x  // 错误：未能解析的引用“x”
    }
}
 */
//在对象表达中可以方便的访问到作用域中的其他变量:
/*
fun countClicks(window: JComponent) {
    var clickCount = 0
    var enterCount = 0

    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent) {
            clickCount++
        }

        override fun mouseEntered(e: MouseEvent) {
            enterCount++
        }
    })
    // ……
}
 */
