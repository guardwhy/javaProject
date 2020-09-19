package cn.guardwhy_05;

import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 System代表了当前系统。
 System类的方法：
     -- public static long currentTimeMillis()：获取系统当前此刻的时间毫秒值！
     -- public static void exit(int status)：终止当前正在运行的 Java 虚拟机
        0代表正常结束，非0代表异常结束！！
     -- public static void arraycopy(Object src , int srcPos ,Object dest, int destPos,
        int length)：数组拷贝，数组复制。
 */
public class SystemDemo08 {
    public static void main(String[] args) {
        // 得到此刻时间毫秒值
        long time = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println("格式化时间:" + sdf.format(time));    // 格式化时间:2020/09/17 19:08:10

        // 终止当前正在运行的Java虚拟机。参数用作状态码.根据惯例,非0的状态码表示异常终止。
        // System.exit(0);

        // 数组拷贝
        int[] arr1 = new int[]{10, 20, 30, 40, 50, 60};
        int[] arr2 = new int[6];

        /**
         * arraycopy(Object src,   参数一：原数组
         *           int  srcPos,  参数二：从哪个元素索引位置开始复制。
         *           Object dest,  参数三：目标数组
         *           int destPos,  参数四：复制到目标数组的哪个位置开始！
         *           int length)   参数五：复制多少个元素
         */
        System.arraycopy(arr1, 0, arr2, 0, 5);
        System.out.println("arr2数组元素:" + Arrays.toString(arr2));

        System.out.println("程序结束....");
    }
}
