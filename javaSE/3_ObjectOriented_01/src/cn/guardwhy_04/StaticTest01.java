package cn.guardwhy_04;
/**
 * 静态成员变量的访问格式:
 *     类名称.静态成员变量。
 *     对象名称.静态成员变量.(不推荐的)
 *
 * 实例成员变量的访问格式:
*     对象名称.实例成员变量
 */
public class StaticTest01 {
    // 1.静态成员:有static修饰,属于类本身,直接用类名访问即可
    public static String schoolName = "中山大学";
    // 2.成员变量:无static修饰,属于类的每个对象的,必须用对象名称访问
    public  String name;
    public int age;

    public static void main(String[] args) {
        // 1. 类名称.静态成员变量
        System.out.println(StaticTest01.schoolName);
        // 注意:同一个类中,访问静态成员可以省略类名不写。
        System.out.println(schoolName);

        // 2.对象名称.实例成员变量
        StaticTest01 st = new StaticTest01();
        st.name = "curry";
        st.age = 10;
        // 输出结果
        System.out.println("姓名:" + st.name + ", 年龄:" + st.age);
    }
}
