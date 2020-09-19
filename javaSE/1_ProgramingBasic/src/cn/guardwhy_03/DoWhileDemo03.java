package cn.guardwhy_03;

/**
 * do...while循环
 */
public class DoWhileDemo03 {
    public static void main(String[] args) {
        // 定义整型变量
        int x = 1;
        // 保存累计值
        int sum = 0;
        // 条件遍历
        do{
            sum += x;
            x++;
        }while (x <= 10);

        // 输出结果
        System.out.println("1到10的累加结果为: " + sum);
    }
}
