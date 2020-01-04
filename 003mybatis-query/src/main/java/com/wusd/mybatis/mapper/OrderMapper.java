package com.wusd.mybatis.mapper;

import com.wusd.mybatis.entity.po.Order;
import com.wusd.mybatis.entity.OrderDetail;

/**
 * @author wusd
 * @date 2019/12/20 17:22
 */
public interface OrderMapper {
    void insert(Order model);

    Order selectById(Integer id);

    OrderDetail selectDetailById(Integer id);
}
