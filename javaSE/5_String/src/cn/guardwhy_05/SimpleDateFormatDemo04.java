package cn.guardwhy_05;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 DateFormat日期格式化

 DateFormat的作用：
     1.可以把日期对象或者时间毫秒值转换成我们喜欢的字符串时间格式。
     2.也可以把字符串时间解析成日期对象。

 DateFormat:
     包：java.text
     这个类是一个抽象的父类，不能直接使用，我们要用它的子类：SimpleDateFormat

 SimpleDateFormat(简单日期格式化对象):
     a.构造器：public SimpleDateFormat(String pattern):定制格式
     b.方法
     -- public String format(Date d):把日期对象转换成格式化的字符串时间返回
     -- public String format(Object time):把时间毫秒值转换成格式化的字符串时间返回
     -- public Date parse(String time):把字符串的时间解析成日期对象。
 */
public class SimpleDateFormatDemo04 {
    public static void main(String[] args) {
        // 1.得到系统此刻时间
        Date d1 = new Date();
        System.out.println("当前系统此刻日期时间:" + d1); // 当前系统此刻日期时间:Thu Sep 17 16:03:44 CST 2020
        // 2.创建一个简单日期格式化对象用于格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss EEE a");
        // 3.把日期格式化成字符串
        String rs = sdf.format(d1);
        System.out.println("格式化时间:" + rs);  // 格式化时间:2020年09月17 16:06:46 星期四 下午
    }
}
