package cn.guardwhy_05;

import java.util.Date;

/**
Date类代表了：当前系统的当前此刻日期信息对象。

Date类的API详情：
     a.包 java.util.Date 需要导入包的。
     b.常用构造器：
     -- public Date()
     -- public Date(long time)
     c.方法
     -- public long getTime()：返回从1970-01-01 00:00:00走到此刻的总的时间毫秒值。
     1000ms = 1s
Java记录时间的两种方式:
     1.可以直接用Date日期类对象记录：Date d = new Date();
     2.可以直接使用时间毫秒值：从1970-01-01 00:00:00走到此刻的总的时间毫秒值

总结：
     当前此刻日期对象：Date
     表示此刻时间的两种形式:
     -- Date d = new Date()
     -- long time = d.getTime(); 使用时间毫秒值
 */
public class DateDemo01 {
    public static void main(String[] args) {
        // 1.创建一个日期对象
        Date d = new Date();
        // 输出当前系统此刻日期时间信息
        System.out.println(d);  // hu Sep 17 15:20:52 CST 2020

        // 2.获取当前系统此刻时间毫秒值
        long time = d.getTime();
        System.out.println(time);   // 1600327441960
    }
}
