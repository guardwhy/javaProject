package cn.guardwhy_02;

/**
 * 带参数方法
 */
public class MethodTest02 {
    public static void main(String[] args) {
        // 定义整型变量
        int a = 30;
        int b = 45;

        // 定义方法
        getMax(a, b);
    }

    public static void getMax(int a, int b) {
        // 条件判断
        if(a > b){
            System.out.println("a的值是:" + a);
        }else {
            System.out.println("b的值是:" + b);
        }
    }
}
