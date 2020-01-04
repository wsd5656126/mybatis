package com.wusd.mybatis.entity.query;

import lombok.Data;

import java.util.List;

@Data
public class OrderQuery {
    private List<Integer> idList;
    private Integer orderStatus;
    private String orderName;
}
