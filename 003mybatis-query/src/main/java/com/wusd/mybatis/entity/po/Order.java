package com.wusd.mybatis.entity.po;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @author wusd
 * @date 2019/12/20 17:15
 */
@Data
public class Order {
    private Integer id;
    private Integer userId;
    private String orderNo;
    private String orderName;
    private Byte orderStatus;
    private Timestamp createTime;
}
