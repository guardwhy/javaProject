package cn.guardwhy.controller;

import cn.guardwhy.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 账户表现层
 */
public class AccountController {

    public static void main(String[] args) {
        // 1.加载spring配置文件，创建spring ioc容器
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");

        // 2.获取账户service
        AccountService accountService = (AccountService)context.getBean("accountService");

        // 3.转账操作
        accountService.transfer("curry","james",200f);
    }
}
