package cn.guardwhy_15;
/**
 JDK 1.8开始之后，接口不再纯洁了，接口中还新增了三个方法：
 （1）默认方法（实例方法）：必须用接口的实现类的对象访问。
 （2）静态方法：必须（只能）用接口的名称来访问。
 （3）私有方法（私有的实例方法）：只能在接口中被其他方法（默认方法，私有方法）访问
 */

interface Person {
    // 1.默认会加上public修饰,其实就是实例方法。
    default void run(){
        System.out.println("学生开始跑步锻炼...");
        // study();
    }

    // 2.静态方法:默认会加上public修饰
    static void eat(){
        System.out.println("学生开始吃饭....");
    }

    // 3.私有方法
    /*private void study(){
        System.out.println("开始学习..");
    }*/
}

class Student implements Person{

}

public class InterfaceDemo01 {
    public static void main(String[] args) {
        // 创建对象stu
        Student stu = new Student();
        // 对象调用方法
        stu.run();
        Person.eat();
    }
}
