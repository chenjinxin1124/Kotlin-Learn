package delegation

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Created by chenjinxin on 2020-04-02 11:51
 */
/*
提供委托
通过定义 provideDelegate 操作符，可以扩展创建属性实现所委托对象的逻辑。
如果 by 右侧所使用的对象将 provideDelegate 定义为成员或扩展函数，那么会调用该函数来 创建属性委托实例。
provideDelegate 的一个可能的使用场景是在创建属性时（而不仅在其 getter 或 setter 中）检查属性一致性。
例如，如果要在绑定之前检查属性名称，可以这样写：
 */
class ResourceLoader(id: ResourceID) {
    val d: ResourceID = id
    operator fun provideDelegate(thisRef: MyUI, prop: KProperty<*>): ReadOnlyProperty<MyUI, String> {
        if (checkProperty(thisRef, prop.name)) {
            return DellImpl(d)
        } else {
            throw Exception("Error ${prop.name}")
        }
    }

    private fun checkProperty(thisRef: MyUI, name: String): Boolean {
        return name.equals("image") || name.equals("text")
    }
}

/*
provideDelegate 的参数与 getValue 相同：

thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型
property —— 必须是类型 KProperty<*> 或其超类型。
 */
fun bindResource(id: ResourceID): ResourceLoader {
    var res = ResourceLoader(id);
    return res
}
//在创建 MyUI 实例期间，为每个属性调用 provideDelegate 方法，并立即执行必要的验证。
//如果没有这种拦截属性与其委托之间的绑定的能力，为了实现相同的功能， 你必须显式传递属性名，这不是很方便：
// 检查属性名称而不使用“provideDelegate”功能
class MyUI {
    val image by bindResource(ResourceID())
    val text by bindResource(ResourceID())
    //val webview by bindResource(ResourceID())
}
class ResourceID() {
    val image_id: String = "101"
    val text_id: String = "102"
}

class DellImpl(d: ResourceID) : ReadOnlyProperty<MyUI, String> {
    val id: ResourceID = d
    override fun getValue(thisRef: MyUI, property: KProperty<*>): String {
        if (property.name.equals("image"))
            return property.name + "  " + id.image_id
        else
            return property.name + "  " + id.text_id
    }
}



fun main(args: Array<String>) {
    try {
        var ui = MyUI()
        println(ui.image)
        println(ui.text)
    } catch (e: Exception) {
        println(e.message)
    }
    //image  101
    //text  102
}
//注意，provideDelegate 方法只影响辅助属性的创建，并不会影响为 getter 或 setter 生成的代码。