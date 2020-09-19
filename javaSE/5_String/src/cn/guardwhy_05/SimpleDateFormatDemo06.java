package cn.guardwhy_05;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 SimpleDateFormat(简单日期格式化对象):
     a.构造器：public SimpleDateFormat(String pattern)定制格式。
     b.方法
     -- public String format(Date d):      把日期对象转换成格式化的字符串时间返回。
     -- public String format(Object time): 把时间毫秒值转换成格式化的字符串时间返回。
     -- public Date parse(String time):    把字符串的时间解析成日期对象。
总结：
     SimpleDateFormat可以把字符串时间解析成日期对象。
     注意：解析时间的格式必须与被解析时间的格式完全一致，否则解析失败！
 */
public class SimpleDateFormatDemo06 {
    public static void main(String[] args) throws ParseException {
        // 面试题:已知一个时间是 2020-09-17 10:40:01,请问1天2小时,21分后的时间是多少。
        // 1.定义一个字符串存储当前时间
        String timStr = "2020/09/17 10:40:01";
        // 2.将字符串的时间解析成日期对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // 3.字符串时间就成了日期对象
        Date d1 = sdf.parse(timStr);

        // 4.得到时间毫秒值
        long time = d1.getTime();
        // 5.往后走1天2小时,21分
        time += (26*60 + 21)*60*1000;
        // 6.格式化输出
        System.out.println("日期格式化:" + sdf.format(time));    // 日期格式化:2020/09/18 13:01:01
    }
}
