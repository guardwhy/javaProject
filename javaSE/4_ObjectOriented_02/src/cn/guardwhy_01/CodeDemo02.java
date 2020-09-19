package cn.guardwhy_01;
/**
 实例代码块：
 -- 无static修饰的，属于类的每个对象的，会与对象一起加载，每次创建对象的时候都会自动执行一次。
 -- 格式： {}
 -- 可以用于初始化实例资源的数据。
 总结:
 实例代码块属于类的每个对象，会与对象一起加载并执行。
 实例代码块可以用于初始化实例资源的数据。
 */
public class CodeDemo02 {
    // 成员变量
    private String name;
    // 实例化代码
    {
        name = "curry";
        System.out.println("实例代码块被触发执行...");    // 实例代码块被触发执行...
    }

    public CodeDemo02(){

    }

    // 代参构造器
    public CodeDemo02(String n) {

    }

    public static void main(String[] args) {
        // 创建stu对象
        CodeDemo02 stu = new CodeDemo02();
        System.out.println(stu.name);   // curry
    }
}
