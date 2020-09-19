package cn.guardwhy_06;
/**
 设计一个电脑对象，可以接入2个USB设备（鼠标，键盘，实现接入，调用独有功能，拔出）。
 分析：
     （1）提供2个USB设备。（USB设备必须满足：接入和拔出的功能）
     （2）定义一个USB的接口（申明USB设备的规范必须是实现接入和拔出的功能）
     （3）开始定义2个真实的实现类代表书鼠标和键盘
     （4）定义一个电脑类。
*/

// KeyBoard(键盘)
class KeyBoard implements USB{
    // 成员变量
    private String name;

    // 代参构造器
    public KeyBoard(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(name + "接入成功!!!");
    }

    @Override
    public void unconnection() {
        System.out.println(name + "拔出成功...");
    }

    // 独有功能
    public void keydown(){
        System.out.println(name + "写出了kobe is mvp !!!");
    }
}

// 鼠标
class Mouse implements USB{
    // 成员变量
    private String name;

    // 代参构造器
    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println(name + "接入成功!!!");
    }

    @Override
    public void unconnection() {
        System.out.println(name + "拔出成功...");
    }

    // 独有功能
    public void dbclick(){
        System.out.println(name + "双击点亮了小星星...");
    }
}

class Computer{
    // 提供安装USB设备
    public void install(USB usb){
        // 接入操作
        usb.connect();
        // 独有功能。usb到底是鼠标还是键盘?
        if(usb instanceof Mouse){
            Mouse m = (Mouse)usb;
            m.dbclick();
        }else if(usb instanceof KeyBoard){
            KeyBoard k = (KeyBoard) usb;
            k.keydown();
        }
        // 拔出
        usb.unconnection();
    }
}
public class ComputerDemo01 {
    public static void main(String[] args) {
        // 创建一部电脑对象
        Computer mac = new Computer();
        // 创建2个usb设备
        Mouse m = new Mouse("小米鼠标");
        KeyBoard k = new KeyBoard("罗技键盘");
        // 安装USB设备
        mac.install(m);
        mac.install(k);
    }
}
