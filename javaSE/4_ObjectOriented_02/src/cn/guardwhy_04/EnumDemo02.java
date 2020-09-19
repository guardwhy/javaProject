package cn.guardwhy_04;

/**
 * 枚举案例
 */

// 季节枚举
enum Season{
    SPRING, SUMMER, AUTUMN, WINTER;
}
// Date
enum WeekDay{
    MONDAY, TUSDAY, WENSDAY, THURSDAY, FRIDAY, SATUDAY, SUNDAY;
}
// 性别
enum SEX{
    BOY, GIRL;
}
public class EnumDemo02 {
    public static void main(String[] args) {
        SEX sex = SEX.BOY;
        // 输出结果
        System.out.println(sex);    // BOY

        SEX sex1 = SEX.GIRL;
        System.out.println(sex1);  // GIRL

        // public final int ordinal():可以返回当前枚举类型的索引位置。
        System.out.println(SEX.BOY.ordinal());  // 0
        System.out.println(SEX.GIRL.ordinal()); // 1
        System.out.println(WeekDay.SUNDAY.ordinal());   // 6

        // public static T[] values():获取当前枚举类的全部实例对象:
        Season[] ss = Season.values();  // 1
        System.out.println(ss.length);  // 6
        System.out.println(ss[3]);  // WINTER

        // 可以通过枚举实例的名称去得到该枚举对象
        Season s = Season.valueOf("SPRING");
        // 输出该对象
        System.out.println(s);  // SPRING
    }
}
