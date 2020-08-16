package cn.guardwhy_03;

/**
 * 关键字break和continue区别
 */
public class forDemo05 {
    public static void main(String[] args) {
        // 调用break方法
        System.out.println("调用break方法:");
        printBreak();

        // 调用continue方法
        System.out.println("调用continue方法:");
        printContinue();
    }

    // 实现continue方法
    public static void printContinue() {
        for(int i=0; i<=10; i++){
            // 条件判断
            if(i == 3){
                // 退出一次循环
                continue;
            }
            System.out.println("i=" + i);
        }
    }

    // 实现break方法
    public static void printBreak() {

        for(int i=0; i<=10; i++){
            // 条件判断
            if(i == 3){
                // 退出循环
                break;
            }
            System.out.println("i=" + i);
        }
    }
}
