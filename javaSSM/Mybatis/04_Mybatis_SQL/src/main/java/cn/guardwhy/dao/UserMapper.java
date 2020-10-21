package cn.guardwhy.dao;

import cn.guardwhy.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户dao的接口
 */
public interface UserMapper {
    // 1.根据用户名称和性别查询用户
    List<User> findUserByNameAndSex(User user);

    // 2.更新用户
    int updateUser(User user);

    // 3.批量添加用户
    int addUsers(List<User> users);

    // 4.批量删除用户
    int deleteUsers(int[] ids);

    // 5.根据条件查询多个用户
    List<User> findUserByCondition(Map<String, Object> condition);

    // 6.根据条件查询有多少用户
    int findUserCount(Map<String, Object> condition);
}
