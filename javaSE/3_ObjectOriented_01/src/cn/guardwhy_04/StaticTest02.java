package cn.guardwhy_04;
/**
 *  成员方法的分类和访问：
 *  静态方法：
 *    类名称.静态方法。
 *    对象名称.静态方法。（不推荐）
 *
 *   实例方法：
 *     对象名称.实例方法。
 *
 *   小结：
 *     静态方法直接用类名访问即可。
 *     实例方法必须用对象访问，否则报错。
 *     静态方法也可以用对象访问，但是这个语法不推荐使用！
 */
public class StaticTest02 {
    // 实例成员变量
    private String name;
    private int age;

    // 静态方法:有static修饰,属于类的,能够直接类名调用.
    public static void inAddr(){
        System.out.println("我们都住在中国大陆...");
    }

    // 实例方法:无static修饰,属于类的每个对象的,必须用类的对象来访问。
    public void runFunction(){
        System.out.println(this.name + "已经" + this.age + "了,还在打篮球...");
    }


    public static void main(String[] args) {

        /**
         * 1.类名称.静态方法
         * @param args
         */
        StaticTest02.inAddr();

        /**
         * 2.对象名称.实例方法
         * @param args
         */
        StaticTest02 stu = new StaticTest02();
        // 成员变量赋值
        stu.name = "curry";
        stu.age = 10;
        // 对象调用方法
        stu.runFunction();
    }
}
