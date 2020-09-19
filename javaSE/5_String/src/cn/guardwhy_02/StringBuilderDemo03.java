package cn.guardwhy_02;
/**
 * StringBuilder和String相互转换
 */
public class StringBuilderDemo03 {
    public static void main(String[] args) {
        // 1.StringBuilder转换为String
        StringBuilder sb1 = new StringBuilder();
        // 添加数据
        sb1.append("guardwhy");
        // 通过toString()就可以实现把StringBuilder转换为String
        String str1 = sb1.toString();
        // 输出字符串
        System.out.println("StringBuilder转换为String:" + str1);

        // 2.将String转换为StringBuilder
        String sb2 = "hello";
        // 通过构造方法就可以实现把String转换为StringBuilder
        StringBuilder str2 = new StringBuilder(sb2);
        // String转换为StringBuilder
        System.out.println("String转换为StringBuilder:" + str2);
    }
}
