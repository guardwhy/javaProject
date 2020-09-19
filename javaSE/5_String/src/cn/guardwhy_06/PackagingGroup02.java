package cn.guardwhy_06;
/**
包装类的特殊功能:
     功能1：包装类成为类了，所有拥有了类的功能。toString方法，equals方法。(没叼用)
     功能2: 包装类可以把基本数据类型的值转换成字符串。(没叼用)
     功能3: 把字符串类型的数字转化成对应的基本数据类型的值！！（真的有用，而且挺重要）
         public static int parseInt(String s):把字符串数字转换成整型!
         public static double parseDouble(String s):把字符串数字转换成double类型!
         Xxxx.parseXxxx("字符串数字"):已经不用！！

         Xxxx.valueOf("字符串数字"):建议方法
总结：
 包装类加入了把字符串的数字转换成对应的基本数据类型的值。从此包装类有使用之地了
 */
public class PackagingGroup02 {
    public static void main(String[] args) {
        // 定义变量
        Integer age1 = 12;
        // 1.基本数据类型调用toString()方法得到字符串。
        String age2 = age1.toString();
        System.out.println("年龄age2是:" + age2+1);    // 年龄age2是:121

        String age3 = age1.toString(age1);
        System.out.println("年龄age3是:" + age2+1);    // 年龄是age3:121

        String age4 = age1 + ""; // 常用方式,直接把整数加字符串变成了字符串！
        System.out.println("年龄age4是:" + age3 + 1);  // 年龄age4是:121

        // 把字符串类型的数字转化成对应的基本数据类型的值
        String num1 = "23";
        int numInt = Integer.valueOf(num1);
        System.out.println("numInt的值:" + numInt);   // numInt的值:23

        // 定义字符串
        String num2 = "99.09";
        Double num2Double = Double.valueOf(num2);
        // 输出字符串
        System.out.println("num2Double的值:" + num2Double);   // num2Double的值:99.09
    }
}
