package cn.guardwhy_04;
/**
 枚举是一种特殊的类型。枚举类型的代表是Enum。
 枚举的作用？可以用于做信息分类和信息标志。

定义枚举的格式:
    enum 枚举名称{
        // 第一行是枚举实例，相当是多个实例对象。
    }

枚举的特点:
 枚举类是用final修饰的，枚举类不能被继承。枚举类默认继承了  java.lang.Enum<Oritation>
 枚举类第一行只能罗列的是当前枚举类的对象，枚举相当于是多例模式.枚举类的构造器默认是私有的,不能在外部创建对象。

总结:
    枚举是在第一行罗列多个实例对象，枚举相当于是多例模式。
    枚举是通过这些实例的名称做信息分类。枚举做信息分类非常严谨,可读性比较好。
*/

// 定义枚举做信息分类
enum Oritation {
    UP, DOWN, LEFT, RIGHT; // 定义四个信息
}
public class EnumDemo01 {
    public static void main(String[] args) {
        run(Oritation.LEFT);    // 往左跑
    }

    // 枚举做信息分类:很严谨,很直观,只能传入枚举的类型,而且可读性很好.
    public static void run(Oritation ot){
        switch (ot){
            case UP:
                System.out.println("向上跳");
                break;
            case DOWN:
                System.out.println("向下蹲");
                break;
            case LEFT:
                System.out.println("往左跑");
                break;
            case RIGHT:
                System.out.println("向右跑");
                break;
        }
    }
}
