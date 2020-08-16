package cn.guardwhy_02;

/**
 * 带返回值参数
 */
public class MethodTest03 {
    public static void main(String[] args) {
        // 定义方法getMax(),通过result变量保存。
        int result = getMax(30, 23);

        // 输出结果值
        System.out.println("最大值是:" + result);
    }

    //定义一个方法，用于获取两个数字中的较大数
    public static int getMax(int a, int b) {
        // 条件判断
        if( a > b){
            return a;
        }else {
            return b;
        }
    }
}
