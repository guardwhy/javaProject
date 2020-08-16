package cn.guardwhy_03;

import java.util.Scanner;

/**
 * 查找元素在数组中出现的索引位置
 */
public class ArrayIndex06 {
    public static void main(String[] args) {
        // 定义一个数组，用静态初始化完成数组元素的初始化
        int[] arr = {19, 28, 37, 46, 50};

        // 键盘录入要查找的元素
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的元素: ");
        // 用变量来接收元素
        int number = sc.nextInt();

        // 调用方法
        int index = getIndex(arr, number);
        System.out.println("输出的索引值是:" + index);
    }

    // 查找指定的数据在数组中的索引
    public static int getIndex(int[] arr, int number) {
        // 定义索引变量,初始化数值为-1
        int index = -1;
        // 遍历数组中的每一个元素,进行比较
        for(int i=0; i< arr.length; i++){
            // 条件判断
            if(arr[i] == number){
                index = i;
                break;
            }
        }
        // 返回索引
        return index;
    }
}
