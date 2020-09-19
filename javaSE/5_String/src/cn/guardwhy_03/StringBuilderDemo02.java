package cn.guardwhy_03;
/**
 StringBuilder类除了可以做字符串拼接操作，还可以进行字符串的插入，删除，反转，修改等操作。
 */
public class StringBuilderDemo02 {
    public static void main(String[] args) {
        // 创建sb对象
        StringBuilder sb = new StringBuilder();
        // 添加元素
        sb.append("Java是").append("最牛逼的语言");
        System.out.println("字符串:" + sb);

        // 插入元素
        sb.insert(5, "世界上");
        System.out.println("字符串(插入):" + sb);

        // 删除指定区间的字符,包前不包后的。
        sb.delete(5,8);
        System.out.println("字符串(删除):" + sb);

        // 根据索引删除某一个字符
        sb.deleteCharAt(sb.length() - 1);
        System.out.println("字符串(删除某一个字符串的字符):" + sb);

        // 内容反转
        sb.reverse();
        System.out.println("字符串(反转):" + sb);
    }
}
