package cn.guardwhy.dao;

import cn.guardwhy.enty.User;

import java.util.List;

/**
 * 数据访问层方法
 */
public interface UserMapper {
    // 查找所有用户
    List<User> findAllUsers();
}
