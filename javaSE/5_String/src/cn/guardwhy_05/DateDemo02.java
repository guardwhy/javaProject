package cn.guardwhy_05;

import java.util.Date;

/**
 时间毫秒值可以用于做时间的运算。
 */
public class DateDemo02 {
    public static void main(String[] args) {
        // 1.提取此刻当前时间的毫秒值
        Date d1 = new Date();
        long startTime = d1.getTime();

        for(int i=0; i<1000; i++){
            System.out.println(i);
        }

        //2.再提取执行完毕以后的当前时间的时间毫秒值
        Date d2 = new Date();
        long endTime = d2.getTime();

        // 3.输出性能时间
        System.out.println("耗时:" + (endTime - startTime) / 1000.0); // 耗时:0.006
    }
}
