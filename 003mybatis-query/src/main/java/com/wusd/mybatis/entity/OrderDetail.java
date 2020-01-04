package com.wusd.mybatis.entity;

import com.wusd.mybatis.entity.po.Order;
import com.wusd.mybatis.entity.po.User;
import lombok.Data;

/**
 * @author wusd
 * @date 2019/12/20 17:24
 */
@Data
public class OrderDetail extends Order {
    private User user;
}
