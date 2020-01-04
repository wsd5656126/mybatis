package com.wusd.mybatis.mapper;

import com.wusd.mybatis.entity.po.Order;
import com.wusd.mybatis.entity.OrderDetail;
import com.wusd.mybatis.entity.query.OrderQuery;

import java.util.List;

/**
 * @author wusd
 * @date 2019/12/20 17:22
 */
public interface OrderMapper {
    void insert(Order model);

    Order selectById(Integer id);

    OrderDetail selectDetailById(Integer id);

    List<Order> selectList(OrderQuery orderQuery);
}
