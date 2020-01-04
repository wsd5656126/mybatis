package com.wusd.mybatis.mapper;

import com.wusd.mybatis.entity.UserDetail;
import com.wusd.mybatis.entity.po.User;

/**
 * @author wusd
 * @date 2019/12/20 17:22
 */
public interface UserMapper {
    void insert(User user);
    User selectById(Integer id);
    UserDetail selectDetailById(Integer id);
}
