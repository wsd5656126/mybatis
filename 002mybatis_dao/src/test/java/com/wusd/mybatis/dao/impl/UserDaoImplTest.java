package com.wusd.mybatis.dao.impl;

import com.wusd.mybatis.dao.UserDao;
import com.wusd.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author wusd
 * @date 2019/12/14 23:56
 */
public class UserDaoImplTest {
    public SqlSessionFactory sqlSessionFactory;
    private UserDao userDao;

    @Before
    public void init() throws Exception {
        String url = "sqlMapConfig.xml";
        //将文件转成字节流
        InputStream inputStream = Resources.getResourceAsStream(url);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        userDao = new UserDaoImpl(sqlSessionFactory);
    }

    @Test
    public void selectById() {
        User user = userDao.selectById(2);
        System.out.println();
    }

    @Test
    public void selectByUsername() {
        List<User> users = userDao.selectByUsername("张");
        System.out.println();
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }
}