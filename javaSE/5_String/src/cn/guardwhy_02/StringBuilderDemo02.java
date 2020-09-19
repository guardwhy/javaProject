package cn.guardwhy_02;
/**
 * StringBuilder类添加和反转方法
 */
public class StringBuilderDemo02 {
    public static void main(String[] args) {
        // 创建对象
        StringBuilder sb = new StringBuilder();
        // 添加数据
        sb.append("kobe").append("is").append("mvp!!!");
        // 输出字符串
        System.out.println("sb字符串:" + sb);

        // public StringBuilder reverse():返回相反的字符序列
        sb.reverse();
        System.out.println("sb字符串:" + sb);
    }
}
