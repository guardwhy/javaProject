package cn.guardwhy_08;
/**
 * 演示匿名内部类的常见使用形式。
 */
public class AnonymityDemo02 {
    public static void main(String[] args) {

        /*
            // 创建对象
            Study st1 = new Study() {
                @Override
                public void studying() {
                    System.out.println("curry正在学习...");
                }
            };
        */

        // 对象调用方法
        start(new Study() {
            @Override
            public void studying() {
                System.out.println("curry正在学习...");
            }
        });

       /*
            // 创建对象
            Study st2 = new Study() {
                @Override
                public void studying() {
                    System.out.println("kobe正在打篮球..");
                }
            };
        */
        start(new Study() {
            @Override
            public void studying() {
                System.out.println("kobe正在打篮球..");
            }
        });
    }

    // 定义一个游泳的方法,让这个角色加入
    public static void start(Study s){
        System.out.println("开始...");
        s.studying();
        System.out.println("结束...");
    }
}
