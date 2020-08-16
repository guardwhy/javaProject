package cn.guardwhy_02;

/**
 * 无参数方法
 */
public class MethodTest01 {
    public static void main(String[] args) {
        // 定义获取最大值的方法
        getMax();
    }

    /**
     * 打印较大值的变量
     */
    public static void getMax() {
        // 定义变量
        int a = 10;
        int b = 8;

        // 判断两个数的大小
        if(a > b){
            System.out.println("较大值是a:" + a);
        }else {
            System.out.println("较大值是b:" + b);
        }
    }
}
