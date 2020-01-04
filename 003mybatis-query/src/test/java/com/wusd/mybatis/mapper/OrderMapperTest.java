package com.wusd.mybatis.mapper;

import com.wusd.mybatis.entity.OrderDetail;
import com.wusd.mybatis.entity.po.Order;
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
public class OrderMapperTest {
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
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = new Order();
        order.setUserId(1);
        order.setOrderNo("004");
        order.setOrderName("买了两双鞋");
        order.setOrderStatus((byte) 1);
        orderMapper.insert(order);
        sqlSession.commit();
    }

    @Test
    public void select() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.selectById(1);
        System.out.println(order);
    }

    @Test
    public void selectDetail() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        OrderDetail orderDetail = orderMapper.selectDetailById(1);
        System.out.println();
    }
}
