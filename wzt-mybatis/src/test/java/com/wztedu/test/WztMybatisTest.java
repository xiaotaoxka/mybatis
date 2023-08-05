package com.wztedu.test;

import com.wztedu.entity.Monster;
import com.wztedu.wztmybatis.sqlsession.Executor;
import com.wztedu.wztmybatis.sqlsession.WztConfiguration;
import com.wztedu.wztmybatis.sqlsession.WztExecutor;
import org.junit.Test;

import java.sql.Connection;

public class WztMybatisTest {

    @Test
    public void build() {
        WztConfiguration wztConfiguration = new WztConfiguration();
        Connection connection = wztConfiguration.build("wzt_mybatis.xml");
        System.out.println("connection--" + connection);
    }

    @Test
    public void query() {
        Executor executor = new WztExecutor();

        Monster monster = executor.query("select * from monster where id = ?", 1);

        System.out.println("monster--" + monster);
    }
}
