package com.wusd.mybatis.entity.po;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author wusd
 * @date 2019/12/20 17:19
 */
@Getter
@Setter
public class User implements Serializable {
    private Integer id;
    private String name;
}
