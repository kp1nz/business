package com.neuedu.dao;

import com.neuedu.pojo.Order;
import com.neuedu.pojo.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated
     */
    List<Order> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_order
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Order record);

    /**
     * 通过用户id和订单编号来查找订单
     */
    Order findOrderByUseridAndOrderNo(@Param("userId") Integer userId, @Param("orderNo") Long orderNo);

    Order findOrderByOrderNo( Long orderNo);

    List<Order> findOrderByUserid(Integer userId);

    /**
     * 按照创建时间查询订单
     */
    List<Order> findOrderByCreateTime(@Param("orderStatus") Integer orderStatus,@Param("time") String time);

    /**
     * 根据订单号查询订单明细
     */
    List<OrderItem> findOrderItemsByOrderno(Long orderNo);
}