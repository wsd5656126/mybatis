package com.wusd.mybatis.mapper;

import com.wusd.mybatis.entity.OrderDetail;
import com.wusd.mybatis.entity.po.Order;
import com.wusd.mybatis.entity.po.User;
import com.wusd.mybatis.entity.query.OrderQuery;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

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
    public void testLoad() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        OrderDetail orderDetail = mapper.selectDetailById(1);
        //直接加载
        System.out.println(orderDetail);
        //侵入式加载
//        System.out.println(orderDetail.getUser());
        //深度延迟加载
//        System.out.println(orderDetail.getUser().getId());
    }
    @Test
    public void testDynamicSql() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setIdList(Arrays.asList(1, 2));
//        orderQuery.setOrderName("买");
        List<Order> orders = mapper.selectList(orderQuery);
        System.out.println();
    }

    @Test
    public void testOneLevelCache() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.selectById(1);
        System.out.println();
        Order order1 = mapper.selectById(1);
        System.out.println();
        Order order2 = new Order();
        order2.setUserId(1);
        order2.setOrderName("orderName3");
        mapper.insert(order2);
        Order order3 = mapper.selectById(1);
        sqlSession.commit();
        System.out.println();
    }

    @Test
    public void testTwoLevelCache() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.selectById(1);
        System.out.println();
        sqlSession.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        OrderMapper mapper2 = sqlSession2.getMapper(OrderMapper.class);
        Order order2 = mapper2.selectById(1);
        System.out.println();
        sqlSession2.close();
    }

}
