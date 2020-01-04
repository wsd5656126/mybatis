package com.wusd.mapper;

import com.wusd.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据用户id查询一个用户信息
     * @param id
     * @return
     */
    User selectById(int id);

    /**
     * 根据用户名称模糊查询用户信息列表
     * @param username
     * @return
     */
    List<User> selectByUsername(String username);

    /**
     * 添加用户
     * @param user
     */
    void insert(User user);

    /**
     * 更新用户
     * @param user
     */
    void update(User user);

    /**
     * 删除用户
     * @param id
     */
    void delete(int id);
}
