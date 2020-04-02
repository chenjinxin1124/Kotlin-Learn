package delegation

/**
 * Created by chenjinxin on 2020-04-02 11:01
 */
/*
把属性储存在映射中
一个常见的用例是在一个映射（map）里存储属性的值。
这经常出现在像解析 JSON 或者做其他"动态"事情的应用中。 在这种情况下，你可以使用映射实例自身作为委托来实现委托属性。
 */
class Site(val map: Map<String, Any?>) {
    val name: String by map
    val url: String  by map
}

fun main(args: Array<String>) {
    // 构造函数接受一个映射参数
    val site = Site(mapOf(
            "name" to "菜鸟教程",
            "url"  to "www.runoob.com"
    ))

    // 读取映射值
    println(site.name)
    println(site.url)
    //菜鸟教程
    //www.runoob.com
}