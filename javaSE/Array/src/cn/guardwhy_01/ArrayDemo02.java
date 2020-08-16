package cn.guardwhy_01;

/**
 * 求数组最值
 */
public class ArrayDemo02 {
    public static void main(String[] args) {
        // 定义数组
        int[] arr = {12, 45, 98, 73, 60};
        // 定义变量保存最大值
        int max = arr[0];

        // 条件遍历,分别与最大值进行比较每次将最大值保存至变量中
        for(int i=1; i<arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }

        // 输出最大值
        System.out.println("该数组的最大值为: " + max);
    }
}
