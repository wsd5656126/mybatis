package com.wusd.mybatis.dao;

import com.wusd.mybatis.entity.User;

import java.util.List;

public interface UserDao {
    User selectById(int id);
    List<User> selectByUsername(String username);
    int insert(User user);
    void update(User user);
    void delete(int id);
}
