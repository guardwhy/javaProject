package cn.guardwhy_03;

/**
 * 方法重载
 */
public class MethodOverload01 {
    public static void main(String[] args) {
        // 输出比较结果
        System.out.println(compare(10, 20));
        System.out.println(compare((byte)10, (byte)20));
        System.out.println(compare((short)10, (short)20));
        System.out.println(compare(10L, 20L));
    }

    // int
    public static boolean compare(int a, int b){
        System.out.println("int");
        return a == b;
    }

    // byte
    public static boolean compare(byte a, byte b){
        System.out.println("byte");
        return a == b;
    }

    // short
    public static boolean compare(short a, short b){
        System.out.println("short");
        return a == b;
    }

    // long
    public static boolean compare(long a, long b){
        System.out.println("long");
        return a == b;
    }
}
