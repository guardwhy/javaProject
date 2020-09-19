package cn.guardwhy_02;

/**
 * if....elseif ...else语句
 */
public class IfElseDemo04 {
    public static void main(String[] args) {
        // 定义整型变量
        int a = 3;
        // 条件判断
        if(a == 1){
            System.out.println("a的值是1");
        }else if(a == 2){
            System.out.println("a的值是2");
        }else if(a == 3){
            System.out.println("a的值是3");
        }else{
            // 其他值
            System.out.println("a的值不是1, 2, 3中的一个..");
        }
    }
}
