package com.wusd.mybatis.mapper;

import com.alibaba.fastjson.JSON;
import com.wusd.mybatis.entity.UserDetail;
import com.wusd.mybatis.entity.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author wusd
 * @date 2019/12/20 18:22
 */
public class UserMapperTest {
    SqlSessionFactory sqlSessionFactory;
    @Before
    public void init() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void insert() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("吴盛东");
        userMapper.insert(user);
        sqlSession.commit();
    }

    @Test
    public void select() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        User user1 = mapper.selectById(2);
        System.out.println();
    }

    @Test
    public void selectDetail() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserDetail userDetail = mapper.selectDetailById(1);
        UserDetail userDetail2 = mapper.selectDetailById(2);
        System.out.println(JSON.toJSONString(userDetail));
        System.out.println(JSON.toJSONString(userDetail2));
    }
}
