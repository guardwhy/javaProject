package cn.guardwhy_11;
/**
 * 接口: 接口是更加彻底的抽象，接口中只能是抽象方法和常量（JDK 1.8之前）
 * 接口特色:
 *      接口体现的是规范思想，实现接口的类必须重写完接口中全部的抽象方法。
 *      接口体现的是一种约束思想（规范）。
 * 接口中成分的特点：
 *      1.接口中只能是抽象方法和常量
 *      2.接口中的抽象方法是可以省略public abstract不写，默认会加上。
 *      3.常量:规范是变量名称全部大写，多个单词用下划线连接，必须有值!!
 *       public static final String SCHOOL_NAME = "黑马" ;
 *       public static final 可以省略不写，默认会加上
 * 总结:
 *      接口中全部是抽象方法和常量（JDK 1.8之前）。
 *      可以省略public abstract不写，默认会加上
 *      public static final 可以省略不写，默认会加上
*/
public interface InterfaceDemo01 {
    // 删除方法
    // public abstract void delete();  // public abstract 默认可以省略不写,默认会加上。
    void delete();

    // 常量定义:规范是变量名称全部大写,多个单词用下划线连接，必须有值!!
    // public static final 可以省略不写,默认会加上
    String SCHOOL_NAME = "中山大学医学院";
}
