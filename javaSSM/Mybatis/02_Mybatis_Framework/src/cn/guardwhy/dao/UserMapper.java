package cn.guardwhy.dao;

import cn.guardwhy.domain.User;

import java.util.List;

/**
 * 数据访问层方法
 */
public interface UserMapper {
    // 查询所有用户
    List<User> findAllUsers();
}
