package cn.guardwhy_03;

/**
 * 数组遍历(方法版本)
 */
public class ArrayMethod03 {
    public static void main(String[] args) {
        // 定义数组,静态初始化
        int[] arr = {11, 22, 33, 55, 6};
        // 调用方法
        printArray(arr);
    }

    // 定义方法,对数组进行遍历
    public static void printArray(int[] arr) {
        System.out.print("[");
        for(int i=0; i<arr.length; i++){
            if(i == arr.length-1){
                System.out.print(arr[i]);
            }else {
                System.out.print(arr[i] + ", ");
            }
        }

        System.out.println("]");
    }
}
