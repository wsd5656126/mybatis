package com.wusd.mybatis.entity;

import com.wusd.mybatis.entity.po.Order;
import com.wusd.mybatis.entity.po.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * @author wusd
 * @date 2019/12/20 17:24
 */
@Setter
@Getter
public class UserDetail extends User implements Serializable {
    private List<Order> orders;
}
