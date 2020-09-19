package cn.guardwhy_13;
/**
 *  接口的多实现: 接口是可以被多实现的，一个类可以实现多个接口。
 *  总结: 一个类实现了多个接口,必须重写完全部接口的全部抽象方法,否则这个类必须定义成抽象类。
 */
public class InterfaceDemo01 {
    public static void main(String[] args) {
        // 创建stu对象
        Student stu = new Student("curry");
        // 对象调用接口方法
        stu.run();  // curry在操场跑步训练..
        stu.study();    // curry在教室准备考试...
        stu.rule(); // curry图书馆看法律书..
    }
}
