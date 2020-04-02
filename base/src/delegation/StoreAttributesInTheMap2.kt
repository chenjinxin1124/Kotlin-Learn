package delegation2

/**
 * Created by chenjinxin on 2020-04-02 11:06
 */
//如果使用 var 属性，需要把 Map 换成 MutableMap：
class Site(val map: MutableMap<String, Any?>) {
    val name: String by map
    val url: String by map
}

fun main(args: Array<String>) {

    var map:MutableMap<String, Any?> = mutableMapOf(
            "name" to "菜鸟教程",
            "url" to "www.runoob.com"
    )

    val site = Site(map)

    println(site.name)
    println(site.url)

    println("--------------")
    map.put("name", "Google")
    map.put("url", "www.google.com")

    println(site.name)
    println(site.url)

    //菜鸟教程
    //www.runoob.com
    //--------------
    //Google
    //www.google.com

}