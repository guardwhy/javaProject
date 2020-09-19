package cn.guardwhy_03;

/**
 * 数组反转
 */
public class ArrayReverse07 {
    public static void main(String[] args) {
        // 定义数组,用静态初始化完成数组元素的初始化
        int[] arr = {19, 28, 37, 46, 50};

        // 反转数组方法
        reverse(arr);

        // 遍历数组
        printArray(arr);
    }


    // 定义反转数组方法
    public static void reverse(int[] arr) {
        // 循环遍历数组,定义两个索引变量,判断开始索引小于等于结束索引
        for(int start=0, end=arr.length-1; start<= end; start++, end--){
            // 交换变量
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    // 定义数组遍历方法
    public static void printArray(int[] arr) {
        System.out.print("[");
        // 遍历数组
        for(int x=0; x<arr.length; x++){
            // 条件判断
            if(x == arr.length-1){
                System.out.print(arr[x]);
            }else {
                System.out.print(arr[x] + ", ");
            }
        }

        System.out.print("]");
    }
}
