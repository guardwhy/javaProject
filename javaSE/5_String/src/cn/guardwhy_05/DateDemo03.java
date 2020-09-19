package cn.guardwhy_05;

import java.util.Date;

/**
 Date日期类的有参数构造器的使用。
 public Date(long time): 可以把时间毫秒值转换成日期对象。

 Date日期对象 -> getTimer() -> 时间毫秒值
 时间毫秒值  -> public Date(long time) -> Date日期对象

 总结:
    public Date(long time): 可以把时间毫秒值转换成日期对象。
 */
public class DateDemo03 {
    public static void main(String[] args) {
        // 1.拿到此刻当前日期对象
        Date d1 = new Date();
        System.out.println("d1的日期对象:" + d1);    // d1的日期对象:Thu Sep 17 15:45:13 CST 2020

        // 2.拿到此刻的时间毫秒值
        long time = d1.getTime();
        // 3.往后走121s
        time += 121 * 1000;

        // 4.把时间毫秒值转换成日期对象输出
        Date d2 = new Date(time);
        System.out.println("d2的日期对象:" + d2);    // d2的日期对象:Thu Sep 17 15:47:14 CST 2020
    }
}
