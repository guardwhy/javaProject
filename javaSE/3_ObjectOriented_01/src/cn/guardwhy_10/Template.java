package cn.guardwhy_10;
/**
模板模式是一种设计模式思想：
模板模式的作用：部分实现，部分抽象，可以极大的简化功能代码。

总结:
    模板思想：部分实现，部分抽象。
    已经确定的模板写好，模板不能确定的定义成抽象方法，交给实现模板的子类去重写！！
    可以简化代码，提高开发效率！
*/
abstract class Template {
    private String title = "\t\t\t\t\t\t《我的学校》";
    private String one = "\t\t我的老师碉堡了，我的老师很牛逼，我的老师是一个很优秀的人。";
    private String last = "\t\t我老师简直太好了，下辈子还要做他学生";

    // 成员方法
    public void write(){
        System.out.println(title);
        System.out.println(one);
        // 正文部分:模板无法确定的,只能抽象成抽象方法出来交给使用模板的人来重写
        System.out.println(writeMain());
        System.out.println(last);
    }

    // 定义一个抽象方法交给子类重写,以便子类返回正文部分的内容
    public abstract String writeMain();
}

// 派生类:Teacher
class Teacher extends Template{

    @Override
    public String writeMain() {
        return "世界那么大，我想去看看...";
    }
}

// 派生类:Student
class Student extends Template{

    @Override
    public String writeMain() {
        return "作业太多，累的半死..";
    }
}