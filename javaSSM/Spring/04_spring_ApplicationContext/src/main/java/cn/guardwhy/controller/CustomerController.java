package cn.guardwhy.controller;

import cn.guardwhy.service.CustomerService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 客户controller
 */
public class CustomerController {
    public static void main(String[] args) {
        /**
          BeanFactory与ApplicationContext区别：
          1.BeanFactory是顶层接口
          2.ApplicationContext是子接口
          3.它们的区别是创建对象的时间点不一样：
            a、BeanFactory采用延迟加载的思想。即什么时候使用对象，什么时候创建
            b、ApplicationContext采用立即创建的思想。即一加载spring配置文件，立即就创建对象
         */

       // 1.创建资源对象
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory context = new XmlBeanFactory(resource);

        // 2.打印容器创建的信息
        System.out.println("------------------start");
        System.out.println("spring IOC容器创建好了");
        System.out.println("-----------------end");

        // 3.从容器中获取客户service对象
        CustomerService customerService = (CustomerService) context.getBean("customerService");
        // 4.保存客户
        customerService.saveCustomer();
    }
}
