package com.wusd.mybatis.entity;

import com.wusd.mybatis.entity.po.Order;
import com.wusd.mybatis.entity.po.User;
import lombok.Data;

import java.util.List;

/**
 * @author wusd
 * @date 2019/12/20 17:24
 */
@Data
public class UserDetail extends User {
    private List<Order> orders;
}
