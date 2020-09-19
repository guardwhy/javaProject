package cn.guardwhy_02;

import java.util.*;

/**
图书管理系统的开发。
 业务需求分析：
     （1）查看全部书籍。query
     （2）添加书本信息。add
     （3）删除书本信息。delete
     （4）修改书本信息。update
     （5）退出系统。 exit

书本信息的结构:
     栏目                书名            价格
     -----------------------------------------
     言情小说
     《金瓶梅》         99.9
     《红楼梦》         198.2
     武侠小说
     《三少爷的剑》      98.2
     《神雕侠侣》        98.2
     ------------------------------------------
分析：
     （1）定义一个集合容器作为图书系统的橱窗。这个容器只需要一个。
     Map<String , List<Book>>
     （2）开发功能。
 */
public class BookSystem {
    // 定义一个集合容器作为系统存储书的对象:这个容器只需要一个。
    public static final Map<String, List<Book>> SYS_BOOK_STORE = new HashMap<>();
    // 定义一个扫描器对象
    public static final Scanner SYS_SCANNER = new Scanner(System.in);
    
    public static void main(String[] args) {
        // 开始显示操作菜单
        showCommand();
    }

    /**
     * 显示操作菜单:
     */
    public static void showCommand() {
        System.out.println("请选择如下命令操作系统：");
        System.out.println("\t（1）查看全部书籍。query");
        System.out.println("\t（2）添加书本信息。add");
        System.out.println("\t（3）删除书本信息。delete");
        System.out.println("\t（4）修改书本信息。update");
        System.out.println("\t（5）退出系统。 exit");
        // 开始接收键盘录入
        System.out.println("请输入操作英文名称: ");
        String command = SYS_SCANNER.nextLine();
        // 判断用户想干啥
        switch (command){
            case "add":
                // 添加书本信息的逻辑
                addBook();
                break;
            case "delete":
                // 删除书本信息的逻辑（作业！）
                break;
            case "update":
                // 修改书本信息的逻辑
                updateBook();
                break;
            case "query":
                // 查看书本信息的逻辑
                queryBook();
                break;
            case "exit":
                // 退出系统
                System.exit(0);
                break;
            default:
                System.err.println("请输入正确的命令！");
        }
        showCommand();
    }

    /**
     * 修改书本信息
     */
    public static void updateBook() {
        // 查看所有书本信息
        queryBook();
        System.out.println("请你输入修改书本的栏目: ");
        String type = SYS_SCANNER.nextLine();
        // 条件判断是否存在这个栏目
        if(SYS_BOOK_STORE.containsKey(type)){
            while (true){
                // 有这个栏目（开始修改书本信息）
                System.out.println("请你输入修改书本的名称: ");
                String name = SYS_SCANNER.nextLine();

                // 判断这个书名是否存在。存在才可以修改，不存在继续输入书名
                // 根据书名去这个栏目的橱窗下找是否有这本书
                Book b = getBookByTypeAndName(type, name);
                // 条件判断
                if(b == null){
                    System.err.println("对不起,你修改的书本不存在...");
                }else {
                    // 书本存在，进入正式修改 。
                    System.out.print("请您输入修改书本的新名称：");
                    String newName = SYS_SCANNER.nextLine();
                    System.out.print("请您输入修改书本的价格：");
                    String price = SYS_SCANNER.nextLine();
                    System.out.print("请您输入修改书本的作者：");
                    String author = SYS_SCANNER.nextLine();
                    b.setName(newName);
                    b.setPrice(Double.valueOf(price));
                    b.setAuthor(author);
                    System.out.println("恭喜您修改成功！");
                    queryBook();
                    break;// 死循环！
                }
            }
        }else {
            // 没有这个栏目
            System.err.println("你的栏目输入有误,请重新确认!!!");
            updateBook();
        }
    }

    /**
     * 根据栏目和书名查询这个栏目下是否有这本书
     * @param type
     * @param name
     * @return
     */
    public static Book getBookByTypeAndName(String type, String name) {
        // 先提取这个栏目下全部的书的集合
        List<Book> books = SYS_BOOK_STORE.get(type);
        // 条件遍历
        for(Book b : books){
            if(b.getName().equals(name)){
                return b;
            }
        }
        return null;
    }

    /**
     * 查看所有书本的信息
     */
    public static void queryBook() {
        System.out.println("---------------查看书本信息-------------------");
        System.out.println(" 栏目\t\t\t书名\t\t\t价格\t\t\t作者\n" +
                "-----------------------------------------");
        SYS_BOOK_STORE.forEach((type , books) -> {
            System.out.println(type);
            for(Book b : books){
                System.out.println("\t\t\t"+b.getName()+"\t\t"+b.getPrice()+"\t\t"+b.getAuthor());
            }
        });
        System.out.println("-------------------------------------------");
    }

    /**
     * 添加书本信息的功能
     */
    public static void addBook() {
        System.out.println("---------------添加书本信息-------------------");
        System.out.print("请您输入添加书本的栏目：");
        String type = SYS_SCANNER.nextLine();
        // 判断这个栏目是否已经存在，如果存在，直接在其其集合中添加新书本
        List<Book> books = null;
        if(SYS_BOOK_STORE.containsKey(type)){
            // 这个栏目已经有
            // 拿到这个栏目的值对象（也就是这个栏目的橱窗是一个List<Book>的集合对象）
            books = SYS_BOOK_STORE.get(type);
        }else{
            // 这个栏目是第一次添加。
            // 创建这个栏目的橱窗，也就是栏目的值,这是第一次创建这个栏目对应的橱窗
            books = new ArrayList<>();
        }
        // 让用户输入书本信息
        System.out.print("请您输入添加书本的名称：");
        String name = SYS_SCANNER.nextLine();
        System.out.print("请您输入添加书本的价格：");
        String price = SYS_SCANNER.nextLine();
        System.out.print("请您输入添加书本的作者：");
        String author = SYS_SCANNER.nextLine();
        Book book = new Book(name , Double.valueOf(price),author);
        books.add(book);
        // 把栏目和对应的书本值集合存入到书本信息仓库中
        SYS_BOOK_STORE.put(type, books);
        System.out.println("---------------------添加书本信息成功------------------------");
    }
}
