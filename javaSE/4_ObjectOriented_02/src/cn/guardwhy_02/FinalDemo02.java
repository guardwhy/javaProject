package cn.guardwhy_02;
/**
 * final修饰类，类不能被继承了。
   final修饰方法，方法不能被重写。
   final可以修饰变量的总规则：变量有且仅能被赋值一次。
    -- final可以修饰局部变量。这个变量的值被保护了，不能被修改了！
    -- final可以修饰静态变量:成为常量了,值不变只有一份,变量名称大写,下划线连接。
    final修饰静态变量可以在:静态代码块赋值一次,或者定义的时候赋值一次。
 */
public class FinalDemo02 {
    // 常量:public static final修饰了就是常量.
    public static final String SCHOOL_NAME1 = "中山大学医学院";
    public static final String SCHOOL_NAME2;
    static {
        SCHOOL_NAME2 = "中山大学商学院";
    }

    public static void main(String[] args) {

    }
}
