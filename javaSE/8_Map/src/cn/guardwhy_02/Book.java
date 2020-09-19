package cn.guardwhy_02;
/**
 * 图书类
 */
public class Book {
    private String name; // 书的名称
    private double price; // 书的价格
    private String author; // 书的作者

    // 无参构造器
    public Book() {

    }

    // 带参构造器
    public Book(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
