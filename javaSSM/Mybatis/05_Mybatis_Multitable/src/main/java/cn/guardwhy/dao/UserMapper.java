package cn.guardwhy.dao;

import cn.guardwhy.domain.User;

public interface UserMapper {
    /**
     * 通过uid查找用户和拓展信息
     */
    User findUserAndInfo(int uid);

    /**
     * 查询全部用户数据并且查询用户的所有订单数据
     */
    User findUserAndOrders(int uid);

    /**
     * 通过uid查找用户和他的所有角色
     */
    User findRolesByUserId(int uid);
}
