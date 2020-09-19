package cn.guardwhy_03;

/**
 * for循环
 */
public class forDemo04 {
    public static void main(String[] args) {
        // 定义变量保存累加结果
        int sum = 0;
        // 遍历循环操作
        for(int i=0; i<=10; i++){
            sum += i;
        }

        // 输出结果
        System.out.println("1-10的结果是: " + sum);
    }
}
