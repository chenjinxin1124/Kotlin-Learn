package delegation

/**
 * Created by chenjinxin on 2020-04-02 10:57
 */
/** 可观察属性 Observable **/
/*
observable 可以用于实现观察者模式。

Delegates.observable() 函数接受两个参数: 第一个是初始化值, 第二个是属性值变化事件的响应器(handler)。
在属性赋值后会执行事件的响应器(handler)，它有三个参数：被赋值的属性、旧值和新值：
 */
import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("初始值") {
        prop, old, new ->
        println("旧值：$old -> 新值：$new")
    }
}

fun main(args: Array<String>) {
    val user = User()
    user.name = "第一次赋值"
    user.name = "第二次赋值"
    //旧值：初始值 -> 新值：第一次赋值
    //旧值：第一次赋值 -> 新值：第二次赋值
}