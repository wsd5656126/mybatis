package com.wusd.mybatis.dao.impl;

import com.wusd.mybatis.dao.UserDao;
import com.wusd.mybatis.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @SqlSessionFactory:作用域应用
 * @SqlSession:方法内 方法运行时存在于内存中，多个应用同时使用时，不会存在线程安全问题
 * @Mapper:方法内
 */
public class UserDaoImpl implements UserDao {
    public SqlSessionFactory sqlSessionFactory;

    //注入的形式
    //其他xmlStatement 和 注解Statement都是调用其

    /**
     * 23种设计模式 5创建型 7结构型 11行为型
     * @param sqlSessionFactory
     */
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User selectById(int id) {
        SqlSession sqlSession = null;
        User user = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            //DefaultSqlSession.selectOne->selectList->从configuration.statementMap获取MappedStatement
            //->CachingExecutor->SimpleExecutor
            user = sqlSession.selectOne("com.wusd.mapper.UserMapper.selectById", id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
        return user;
    }

    public List<User> selectByUsername(String username) {
        SqlSession sqlSession = null;
        List<User> users = new ArrayList<>();
        try {
            sqlSession = sqlSessionFactory.openSession();
            users = sqlSession.selectList("com.wusd.mapper.UserMapper.selectByUsername", username);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
        return users;
    }

    public int insert(User user) {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            int id = sqlSession.insert("com.wusd.mapper.UserMapper.insert", user);
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
        return 0;
    }

    public void update(User user) {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("com.wusd.mapper.UserMapper.update", user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }

    }

    public void delete(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("com.wusd.mapper.UserMapper.delete", id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) sqlSession.close();
        }
    }
}
