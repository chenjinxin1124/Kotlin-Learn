package com.cjx.ClassesAndObjects

/**
 * @Auther: cjx
 * @Date: 2020/3/29 17:14
 * @Description:
 */
/** 类定义 **/
/**
 * Kotlin 类可以包含：构造函数和初始化代码块、函数、属性、内部类、对象声明。
 * Kotlin 中使用关键字 class 声明类，后面紧跟类名：
 * class Runoob {  // 类名为 Runoob
    // 大括号内是类体构成
    }

    定义一个空类：
    class Empty

    在类中定义成员函数：
    class Runoob() {
    fun foo() { print("Foo") } // 成员函数
    }
 */

// 定义了一个 Person 类，包含两个可变变量 lastName 和 no，lastName 修改了 getter 方法，no 修改了 setter 方法。
// Koltin 中的类可以有一个 主构造器，以及一个或多个次构造器，主构造器是类头部的一部分，位于类名称之后:
// 如果主构造器没有任何注解，也没有任何可见度修饰符，那么constructor关键字可以省略。
class Person(s: String, i: Int, d: Float) {
    // 类的属性可以用关键字 var 声明为可变的，否则使用只读关键字 val 声明为不可变。
    var lastName: String = s
        // getter 和 setter 都是可选
        // 如果属性类型可以从初始化语句或者类的成员函数中推断出来，那就可以省去类型，val不允许设置setter函数，因为它是只读的。
        get() = field.toUpperCase()   // 将变量赋值后转换为大写
        set

    var no: Int = i
        // Kotlin 中类不能有字段。提供了 Backing Fields(后端变量) 机制,备用字段使用field关键字声明,field 关键词只能用于属性的访问器
        get() = field                // 后端变量
        set(value) {
            if (value < 10) {       // 如果传入的值小于 10 返回该值
                field = value
            } else {
                field = -1         // 如果传入的值大于等于 10 返回 -1
            }
        }

    var heiht: Float = d
        private set

    fun show(): Any? {
        println("lastName:${lastName}")
        println("no:$no")
        println("heiht:${heiht}")
        return null
    }
}

// 非空属性必须在定义的时候初始化,kotlin提供了一种可以延迟初始化的方案,使用 lateinit 关键字描述属性：
/*class TestSubject{
    fun method(){

    }
}
public class MyTest {
    lateinit var subject: TestSubject

    @SetUp fun setup() {
        subject = TestSubject()
    }

    @Test fun test() {
        subject.method()  // dereference directly
    }
}*/

// 测试
fun main(args: Array<String>) {
    // 可以像使用普通函数那样使用构造函数创建类实例：
    var person: Person = Person("a",2,1.9f) // Kotlin 中没有 new 关键字
    person.show()
    // 要使用一个属性，只要用名称引用它即可
    person.lastName = "wang" // // 使用 . 号来引用

    println("lastName:${person.lastName}")

    person.no = 9
    println("no:${person.no}")

    person.no = 20
    println("no:${person.no}")

}
