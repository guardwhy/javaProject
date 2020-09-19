package cn.guardwhy_02;

/**
 * 三目运算符
 */
public class MaxDemo03 {
    public static void main(String[] args) {
        // 定义变量保存最大值
        int max = 0;

        // 定义变量
        int a = 3;
        int b = 10;

        // 通过三目运算符获得最大值
        max = a > b ? a : b;
        System.out.println("较大值是:" + max);
    }
}
