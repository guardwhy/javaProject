package cn.guardwhy_03;
/**
 * 引用类型传递
 */
public class ReferenceType02 {
    public static void main(String[] args) {
        // 静态初始化数组
        int[] arr = {10, 20, 30};
        System.out.println("调用change方法前:" + arr[1]);

        // 定义方法
        change(arr);
        System.out.println("调用change方法后:" + arr[1]);
    }

    // 调用方法
    public static void change(int[] arr) {
        arr[1] = 26;
    }
}
