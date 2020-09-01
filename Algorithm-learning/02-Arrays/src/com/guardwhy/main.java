package com.guardwhy;
/*
* fib(两种实现方式)
* */
public class main {
    public static void main(String[] args) {
        // 定义n变量
        int n = 12;
        System.out.println(fib1(n));
        System.out.println(fib2(n));
    }

    // 算法1(递归)
    public static int fib1(int n) {
        // 当n<=1时，返回n
        if (n <= 1) {
            return n;
        }else {
            return fib1(n - 1) + fib1(n - 2);
        }

    }
    // 算法2
    public static int fib2(int n) {
        if (n <= 1){
            return n;
        }else {
            // 定义第一个为0
            int first = 0;
            // 第二个数为1
            int second = 1;
            for (int i = 0; i < n - 1; i++) {
                int sum = first + second;
                first = second;
                second = sum;
            }
            return second;
        }
    }
}
