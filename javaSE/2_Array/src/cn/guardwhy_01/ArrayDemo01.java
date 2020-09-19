package cn.guardwhy_01;

/**
 * 定义数组和输出数组
 */
public class ArrayDemo01 {
    public static void main(String[] args) {
        // 定义数组
        int[] arr = {11, 22, 33, 44, 55};;
        // 输出数组名
        System.out.println(arr);

        // 遍历数组
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
