package cn.guardwhy_01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**

 编译时异常：继承自Exception的异常或者其子类，没有继承RuntimeException
 编译阶段就会报错，必须程序员处理的。否则代码编译就报错.

 编译时异常：是在编译阶段就直接报错的，目的是担心写代码的程序员技术不行.

总结：
 运行时异常一般是程序员自己写代码引起的。
 编译时异常是提醒程序员这里的代码要注意，可能出错，提醒的更强烈！！
 编译时异常是编译阶段就直接报错，一定要程序员在编译阶段处理的！
 */
public class ExceptionDemo03 {
    public static void main(String[] args) throws ParseException {
        String date = "2018-10-11 10:10:10";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(date);
        System.out.println(d);  // Thu Oct 11 10:10:10 CST 2018
    }
}
