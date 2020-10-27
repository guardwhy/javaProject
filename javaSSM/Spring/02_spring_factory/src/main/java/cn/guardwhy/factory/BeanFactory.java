package cn.guardwhy.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工厂类实现
 */
public class BeanFactory {
    // 1.声明一个私有的工厂类对象引用
    private static BeanFactory beanFactory;
    // 2.将构造方法私有化
    private BeanFactory(){

    }
    // 3.通过静态代码块初始化
    // 定义Properties
    private static Properties prop;
    static {
        // 创建工厂类对象
        beanFactory = new BeanFactory();
        // 创建prop对象,加载属性配置文件
        prop = new Properties();
        InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            prop.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("加载属性资源文件,发生异常:" + e.getMessage());
        }
    }

    // 4.提供一个公有的、静态的方法，获取工厂类对象引用
    public static BeanFactory getBeanFactory(){
        return beanFactory;
    }

    /**
     *  1.通过配置文件，将要创建的目标对象的类型信息，进行配置
     *  2.在工厂类中加载配置文件，通过反射技术实现运行时加载，并创建目标对象
     */
    public Object getBean(String beanName){
        // 目标对象
        Object result = null;
        // 获取类路径
        String className = prop.getProperty(beanName);
        // 反射技术创建对象
        try {
            result = Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("运行时创建对象,发生异常:" + className);
        }
        return result;
    }
}
