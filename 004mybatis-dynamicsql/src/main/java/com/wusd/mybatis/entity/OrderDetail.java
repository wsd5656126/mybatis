package com.wusd.mybatis.entity;

import com.wusd.mybatis.entity.po.Order;
import com.wusd.mybatis.entity.po.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author wusd
 * @date 2019/12/20 17:24
 */
@Setter
@Getter
public class OrderDetail extends Order implements Serializable {
    private User user;
}
