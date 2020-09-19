package cn.guardwhy_01;

/**
 * string类的方法
 */
public class StringDemo01 {
    public static void main(String[] args) {
        // public String():创建一个空白字符串对象
        String s1 = new String();
        System.out.println("s1字符串内容:" + s1);

        // public String(char[] chs):根据字符数组的内容,创建字符串对象
        char[] chs = {'a', 'b', 'c'};
        String s2 = new String(chs);
        System.out.println("s2字符串内容:" + s2);

        //public String(byte[] bys):根据字节数组的内容，来创建字符串对象
        byte[] byts = {97, 98, 99};
        String s3 = new String(byts);
        System.out.println("s3字符串内容:" + s3);

        // 字符串直接赋值操作
        String s4 = "guardwhy";
        System.out.println("s4字符串内容:" + s4);
    }
}
