package cn.guardwhy_02;

/**
 * 自增与自减运算符
 */
public class OperatorDemo02 {
    public static void main(String[] args) {
        // 定义整型变量a和b
        int a = 3, b = 3;
        // 定义整形变量x和y
        int x = 6, y = 6;

        // 输出变量a的值
        System.out.println("a=" + a);
        // 先执行后自增
        System.out.println("a++=" +(a++)+", a=" + a);

        // 输出变量b的值
        System.out.println("b=" + b);
        // 先自增后执行
        System.out.println("++b=" +(++b)+", b=" + b);

        // 输出变量x的值
        System.out.println("x=" + x);
        // 先执行后自减
        System.out.println("x--=" +(x--)+ ", x=" + x);

        // 输出变量y的值
        System.out.println("y=" + y);
        // 先自减后执行
        System.out.println("--y=" +(--y)+", y="+y);
    }
}
