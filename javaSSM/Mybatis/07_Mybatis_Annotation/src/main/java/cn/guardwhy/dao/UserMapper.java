package cn.guardwhy.dao;

import cn.guardwhy.domain.OrderForm;
import cn.guardwhy.domain.User;
import cn.guardwhy.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 持久化接口:UserMapper
 */
public interface UserMapper {
    /**
     * 通过id查找用户
     */
    @Select("select * from user where id = #{id}")
    @Results({
            // column:主表的主键 property:另一方的属性名, one:配置一对一的关联关系
            @Result(column = "id", property = "userInfo",
                    // select:读取另一个对象查询方法 fetchType:LAZY延迟加载,EAGER及时加载。
                    one = @One(select = "findUserInfoById", fetchType = FetchType.LAZY)),
            // 配置1对多的关系,column:主表的主键, property：方法的属性名, many：配置一对多的关联关系
            @Result(column = "id", property = "orders", many = @Many(select = "findOrderByUserId", fetchType = FetchType.LAZY))
    })
    User findUserById(@Param("id") int id);

    /**
     * 通过id查询用户拓展信息
     */
    @Select("select * from user_info where id = #{id}")
    UserInfo findUserInfoById(int id);

    /**
     * 通过userId查询这个用户所有的订单信息
     */
    @Select("select * from order_form where user_id = #{userId}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "create_time", property = "createTime")
    })
    List<OrderForm> findOrderByUserId(int userId);
}
