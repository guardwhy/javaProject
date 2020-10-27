package cn.guardwhy.junit;

import cn.guardwhy.config.SpringConfiguration;
import cn.guardwhy.domain.Customer;
import cn.guardwhy.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * spring整合junit单元测试框架
 *
 * 整合步骤：
 *     1.导入junit单元测试框架包
 *     2.导入spring提供的测试包(spring-test)
 *     3.通过@RunWith注解，把junit的测试类，替换成spring提供的测试类（SpringJUnit4ClassRunner）
 *     4.通过@ContextConfiguration注解，加载spring的配置类
 */
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})

public class SpringJunit {

    // 定义客户service
    @Autowired
    private CustomerService customerService;

    /**
     * 测试查询全部客户列表数据
     */
    @Test
    public void findAllCustomersTest2(){
        // 查询客户列表
        List<Customer> list = customerService.findAllCustomers();
        for(Customer c:list){
            System.out.println(c);
        }
    }
}
