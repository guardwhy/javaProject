package cn.guardwhy_02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 方式三：在出现异常的地方把异常一层一层的抛出给最外层调用者,最外层调用捕获处理(规范做法)
总结：
 方式三是最规范的方式，推荐使用！
 外层可以知道底层执行的情况。即使出现了错误也不会引起程序的死亡，这是最好的方案！
 */
public class ExceptionDemo03 {
    public static void main(String[] args) {
        System.out.println("程序开始....");
        try {
            throwsTest();
            System.out.println("格式化日期成功..");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("对不起,操作失败....");
        }

        System.out.println("程序结束....");
    }

    public static void throwsTest() throws Exception{
        // 定义字符串变量
        String date = "2020-10-11 10:10:10";
        // 创建一个简单日期格式化对象用于格式化时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(date);
        System.out.println("格式化日期:" + d);
    }
}
