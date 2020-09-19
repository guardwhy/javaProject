package cn.guardwhy_05;

import java.math.BigDecimal;

/**
 BigDecimal通常可以用于较大数据的运算,尤其适合做double类型数据的运算,可以避免数据运算失真的问题。
 方法：
     public BigDecimal add(BigDecimal value); 加法
     public BigDecimal subtract(BigDecimal value); 减法
     public BigDecimal multiply(BigDecimal value); 乘法
     public BigDecimal divide(BigDecimal value); 除法
     public double doubleValue()：把大数据转换回double类型。
总结：
     1.创建大数据对象建议用：
         BigDecimal a1 = BigDecimal.valueOf(a);
         不要new对象。
     2.大数据对象可以保证精确运算，运算完毕以后还是要回到double类型的。
 */
public class BigDecimalDemo09 {
    public static void main(String[] args) {
        // 定义变量
        double a = 0.1;
        double b = 0.2;
        // 创建大数据对象,不能使用new,会出问题.
        BigDecimal a1 = BigDecimal.valueOf(a);
        BigDecimal b1 = BigDecimal.valueOf(b);
        // 加完以后还是大数据类型
        BigDecimal rs = a1.add(b1);

        // 将大数据转回double类型
        double db = rs.doubleValue();
        System.out.println("a+b的值是:" + db);     // a+b的值是:0.3
    }
}
