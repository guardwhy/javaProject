package cn.guardwhy_02;
/**
 方式二：在出现异常的地方自己处理，谁出现谁处理。
 自己捕获异常和处理异常的格式：
     try{
     // 可能出现异常的代码！
     }catch(异常类型1 变量){
     // 处理异常
     }catch(异常类型2 变量){
     // 处理异常
     }...
     自己捕获处理的建议格式：（企业级写法）
     try{
     // 可能出现异常的代码！
     }catch(Exception e){
     // e.printStackTrace(); // 可以拦截到全部异常，直接输出打印异常信息
     }
总结：
 方式二的优点：即使程序真的出现了异常，自己捕获处理了，不会引起程序的死亡。
 */
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo02 {
    public static void main(String[] args) {
        System.out.println("程序开始....");
        throwsTest();
        System.out.println("程序结束....");
    }

    // 定义throwsTest方法
    public static void throwsTest(){
        try {
            // 定义字符串变量
            String date = "2020-10-11 10:10:10";
            // 创建一个简单日期格式化对象用于格式化时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d = sdf.parse(date);
            System.out.println("格式化日期:" + d);   // 格式化日期:Sun Oct 11 10:10:10 CST 2020
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
