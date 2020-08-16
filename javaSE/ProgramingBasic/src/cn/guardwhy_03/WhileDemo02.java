package cn.guardwhy_03;

/**
 * while循环
 */
public class WhileDemo02 {
    public static void main(String[] args) {
        // 定义整型变量
        int a = 1;
        // 保存累加结果
        int sum = 0;
        // 条件判断
        while (a <= 10){
            // 执行累计操作
            sum += a;
            a++;
        }

        // 输出结果
        System.out.println("1到10的累加结果为: " + sum);
    }
}
