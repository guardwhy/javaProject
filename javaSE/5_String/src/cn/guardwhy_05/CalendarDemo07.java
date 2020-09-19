package cn.guardwhy_05;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 Calendar代表的是当前系统此刻时间对应的日历对象。是一个抽象类。

 Calendar创建日历对象的方式：
    -- public static Calendar getInstance()：直接返回一个日期对象。
 Calendar的方法：
     -- public int get(int field)：根据参数取日期信息
     -- public Date getTime() : 拿日期的此刻日期对象
     -- public long getTimeInMillis() : 拿此刻时间毫秒值
     -- public void add(int field, int amount):让日历中的某个信息多走一个值！！
 */
public class CalendarDemo07 {
    public static void main(String[] args) {
        // 1.创建日历对象,得到一个系统的日历对象
        Calendar c1 = Calendar.getInstance();
        System.out.println("日历对象:" + c1);

        // 获取年
        int year = c1.get(Calendar.YEAR);
        System.out.println("年:" + year);
        // 天数
        int days = c1.get(Calendar.DAY_OF_YEAR);
        System.out.println("天数:" + days);

        // 获取日历当前日期对象
        Date d = c1.getTime();
        System.out.println("当前日期对象:" + d);

        // 得到此刻时间毫秒值
        long time = c1.getTimeInMillis();
        System.out.println("此刻时间毫秒值:" + time);

        // 往后走多少时间信息。
        // 问 62天的日期,让日期中一年中的第几天往后多走62天,往后翻62页.
        c1.add(Calendar.DAY_OF_YEAR, 62);
        SimpleDateFormat sdf = new SimpleDateFormat("yyy/MM/dd HH:mm:ss");
        System.out.println("时间信息:" + sdf.format(c1.getTimeInMillis()));
    }
}
