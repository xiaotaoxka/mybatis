package com.wztedu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

    // 编写一个静态代码块，初始化 sqlSessionFactory
    static {
        try {
            // 指定资源文件，配置文件 mybatis-config.xml
            String resource = "mybatis-config.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);

            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            System.out.println("sqlSessionFactory= " + sqlSessionFactory.getClass());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    // 编写方法，返回sqlSession对象-会话
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
