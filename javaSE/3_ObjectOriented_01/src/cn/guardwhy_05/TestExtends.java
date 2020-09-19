package cn.guardwhy_05;
/***
 * 小结：
 *    继承可以提高代码的复用性，相同代码可以被重复利用。
 *    子类继承父类,子类就直接得到了父类的属性和行为了,直接就可以直接使用。
 */
public class TestExtends {
    public static void main(String[] args) {
        // 创建对象
        Teacher ts = new Teacher();
        ts.setName("隆多");
        ts.setAge(33);
        // 对象调用成员方法
        ts.eat();
        ts.teach();
    }
}
