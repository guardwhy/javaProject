package cn.guardwhy_01;

/**
 * 对象的实现
 */
public class PhoneDemo {
    public static void main(String[] args) {
        // 创建对象
        Phone p = new Phone();

        //使用成员变量
        System.out.println(p.brand); // null
        System.out.println(p.price); // 0

        // 调用成员变量
        p.brand = "华为";
        p.price = 4599;

        System.out.println(p.brand); // 华为
        System.out.println(p.price); // 4599

        // 调用成员方法
        p.sendMessage(); // 发短信
        p.sendTik(); // 发抖音视频
    }
}
