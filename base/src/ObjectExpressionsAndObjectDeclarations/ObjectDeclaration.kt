package ObjectExpressionsAndObjectDeclarations

/**
 * @Auther: cjx
 * @Date: 2020/4/1 23:51
 * @Description:
 */

/** 对象声明 **/
//Kotlin 使用 object 关键字来声明一个对象。
//
//Kotlin 中我们可以方便的通过对象声明来获得一个单例。
/*
object DataProviderManager {
    fun registerDataProvider(provider: DataProvider) {
        // ……
    }

    val allDataProviders: Collection<DataProvider>
        get() = // ……
}
 */
//引用该对象，我们直接使用其名称即可：
//DataProviderManager.registerDataProvider(……)
//当然你也可以定义一个变量来获取获取这个对象，当时当你定义两个不同的变量来获取这个对象时，你会发现你并不能得到两个不同的变量。也就是说通过这种方式，我们获得一个单例。
/*
var data1 = DataProviderManager
var data2 = DataProviderManager
data1.name = "test"
print("data1 name = ${data2.name}")
 */
//以下实例中，两个对象都输出了同一个 url 地址：
object Site {
    var url:String = ""
    val name: String = "菜鸟教程"
}
fun main(args: Array<String>) {
    var s1 =  Site
    var s2 = Site
    s1.url = "www.runoob.com"
    println(s1.url)
    println(s2.url)
    //www.runoob.com
    //www.runoob.com
}
