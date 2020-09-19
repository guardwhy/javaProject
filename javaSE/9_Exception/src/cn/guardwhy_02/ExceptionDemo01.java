package cn.guardwhy_02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
编译时异常：
    编译阶段就会报错，一定需要程序员处理的，否则代码无法通过！！
抛出格式：
     方法 throws 异常1 ,  异常2 , ..{

     }
    建议抛出格式，直接抛出Exception包含所有的异常类型。
     方法 throws Exception{

     }
编译时异常的处理方式一：在出现异常的地方，一层一层的抛出给调用者，调用者也抛出给JVM虚拟机。

总结：
     方式一，大家都不愿意处理异常，一层一层的抛出给JVM虚拟机，这种方式
     与默认的方式是一样的，依然会在出现异常后引起程序死亡！
 */
public class ExceptionDemo01 {
    public static void main(String[] args) throws Exception{
        System.out.println("程序开始....");
        throwsTest();
        System.out.println("程序结束....");
    }

    // 定义方法
    public static void throwsTest() throws Exception{
        String date = "2020-10-11 10:10:10";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(date);
        System.out.println("格式化日期:" + d);   // 格式化日期:Sun Oct 11 10:10:10 CST 2020
    }
}
