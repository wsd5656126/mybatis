package com.wusd.mybatis.entity.po;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author wusd
 * @date 2019/12/20 17:15
 */
@Setter
@Getter
public class Order implements Serializable {
    private Integer id;
    private Integer userId;
    private String orderNo;
    private String orderName;
    private Byte orderStatus;
    private Timestamp createTime;
}
