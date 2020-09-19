package cn.guardwhy_05;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
DateFormat的作用：
     1.可以把日期对象或者时间毫秒值转换成我们喜欢的字符串时间格式。
     2.也可以把字符串时间解析成日期对象。

SimpleDateFormat(简单日期格式化对象):
     a.构造器：public SimpleDateFormat(String pattern)定制格式

     b.方法
     -- public String format(Date d):      把日期对象转换成格式化的字符串时间返回。
     -- public String format(Object time): 把时间毫秒值转换成格式化的字符串时间返回。
     -- public Date parse(String time):    把字符串的时间解析成日期对象。

总结：
    简单日期格式化对象可以格式化日期对象，但是也可以直接格式化时间毫秒值！
 */
public class SimpleDateFormatDemo05 {
    public static void main(String[] args) {
        // 1.创建一个简单日期格式化对象用于格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss EEE a");
        // 2.得到系统此刻时间
        Date d = new Date();
        System.out.println("格式化时间:" + sdf.format(d));   // 格式化时间:2020年09月17 16:23:23 星期四 下午

        // 3.128s之后的时间,拿到此刻的时间毫秒值。
        long endTime = d.getTime();
        // 往后走128s
        endTime += 128 * 1000;
        // 4.把时间毫秒值转换成格式化的字符串时间返回
        System.out.println("格式化时间:" + sdf.format(endTime)); // 格式化时间:2020年09月17 16:25:31 星期四 下午
    }
}
