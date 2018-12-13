package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

//数据库工具类
public class DatabaseUtil {
    public static SqlSession getSqlSession() throws IOException {

        Reader reader = Resources.getResourceAsReader("databaseConfig.xml");//获取配置的资源文件
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);//加载配置文件
        SqlSession sqlSession = factory.openSession();//sqlSession就sql是能够执行配置文件中的语句

        return sqlSession;

        }

    }

