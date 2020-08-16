package cn.guardwhy_03;

/**
 * 数组最大值(方法版)
 */
public class MethodMax04 {
    public static void main(String[] args) {
        // 定义数组,并且静态初始化
        int[] arr = {12, 45, 98, 73, 60};

        // 调用方法,用变量来接收结果
        int result = getMax(arr);

        // 输出结果
        System.out.println("数组的最大值是:" + result);
    }

    public static int getMax(int[] arr) {
        // 定义最大值
        int max = arr[0];

        // 数组遍历
        for(int i=1; i<arr.length; i++){
            // 数组元素跟最大值比较
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
