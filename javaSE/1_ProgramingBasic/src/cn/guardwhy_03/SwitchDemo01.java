package cn.guardwhy_03;

/**
 * switch语句
 */
public class SwitchDemo01 {
    public static void main(String[] args) {
        // 定义字符串
        String str = "HELLO";
        // 判断字符串
        switch (str){
            case "HELLO":{
                System.out.println("内容是HELLO");
                break;
            }
            case "cpp":{
                System.out.println("内容是cpp");
                break;
            }
            case "java":{
                System.out.println("内容是java");
                break;
            }
            default:{
                System.out.println("没有匹配内容");
                break;
            }
        }
    }
}
