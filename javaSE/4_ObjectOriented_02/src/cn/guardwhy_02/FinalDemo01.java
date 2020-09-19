package cn.guardwhy_02;
/**
 * final是最终的含义.
 *
 *   final可以修饰类，方法，变量。final修饰类，类不能被继承了。
 *   final修饰方法，方法不能被重写。
 *   final可以修饰变量的总规则：变量有且仅能被赋值一次。
 *
 *   -- final可以修饰局部变量。这个变量的值被保护了，不能被修改了！!
 */
public class FinalDemo01 {
    public static void main(String[] args) {
        // 定义变量age
        final int age = 12;
        // age = 15;    // 保错,第二次赋值..

        // 定义变量rate
        final double rate;
        rate = 3.18; // 第一次赋值
        // rate = 4.18; // 报错,二次赋值
    }
}
