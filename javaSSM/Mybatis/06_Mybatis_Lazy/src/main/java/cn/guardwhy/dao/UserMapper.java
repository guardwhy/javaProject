package cn.guardwhy.dao;

import cn.guardwhy.domain.OrderForm;
import cn.guardwhy.domain.User;
import cn.guardwhy.domain.UserInfo;

import java.util.List;

/**
 * 持久化接口:UserMapper
 */
public interface UserMapper {
    /**
     * 通过id查询1个用户
     */
    User findUserById(int id);

    /**
     * 通过id查询1个用户扩展信息
     */
    UserInfo findUserInfoById(int id);

    /**
     通过userId查询这个用户所有的订单信息
     */
    List<OrderForm> findOrdersByUserId(int userId);
}
