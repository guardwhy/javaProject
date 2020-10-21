package cn.guardwhy.dao;

import cn.guardwhy.domain.QueryVo;
import cn.guardwhy.domain.User;

import java.util.List;

/**
 * 用户dao的接口
 */
public interface UserMapper {

    //1.通过id查询一个用户
    User findUserById(Integer id);

    // 2.通过用户名查询用户
    List<User> findUsersByName(String username);

    // 3.新增用户
    int addUser(User user);

    // 4.根据用户Id修改用户
    int updateUser(User user);

    // 5.根据用户id删除用户
    int deleteUser(Integer id);

    // 6.使用POJO包装类型,根据用户名称模糊查询用户
    List<User> findUsersByCondition(QueryVo queryVo);

    // 7.统计用户表中某种性别的数量
    int getAmountBySex(String sex);

    // 8.通过id查询用户
    User findUser2ById(Integer id);
}
