package ObjectExpressionsAndObjectDeclarations

/**
 * @Auther: cjx
 * @Date: 2020/4/1 23:54
 * @Description:
 */

//对象可以有超类型：
/*
object DefaultListener : MouseAdapter() {
    override fun mouseClicked(e: MouseEvent) {
        // ……
    }

    override fun mouseEntered(e: MouseEvent) {
        // ……
    }
}
 */
//与对象表达式不同，当对象声明在另一个类的内部时，这个对象并不能通过外部类的实例访问到该对象，而只能通过类名来访问，
// 同样该对象也不能直接访问到外部类的方法和变量。
class Site2 {
    var name = "菜鸟教程"
    object DeskTop{
        var url = "www.runoob.com"
        fun showName(){
            //print{"desk legs $name"} // 错误，不能访问到外部类的方法和变量
        }
    }
}
fun main(args: Array<String>) {
    var site = Site2()
    //site.DeskTop.url // 错误，不能通过外部类的实例访问到该对象
    println(Site2.DeskTop.url) // 正确
}