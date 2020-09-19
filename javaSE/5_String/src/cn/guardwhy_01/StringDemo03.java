package cn.guardwhy_01;

import java.util.Scanner;

/**
 * 用户登录案例
 */
public class StringDemo03 {
    public static void main(String[] args) {
        // 定义用户名和密码
        String username = "guardwhy";
        String password = "hxy1625309592";
        // 条件判断
        for(int i=0; i<=3; i++){
            // 键盘录入用户名和密码
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入用户名:");
            String name = sc.nextLine();

            System.out.println("请输入密码:");
            String pwd = sc.nextLine();
            // 将用户名,密码和已知用户名密码进行比较.字符串内容比较,用equals()方法实现
            if(name.equals(username) && pwd.equals(password)){
                System.out.println("登录成功..");
                break;
            }else {
                if(2-i == 0){
                    System.out.println("你的账户被锁定,请与管理员联系..");
                }else {
                    System.out.println("登录失败,你还有" + (3-i) + "次机会登录");
                }
            }
        }
    }
}
