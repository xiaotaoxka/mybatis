package com.wztedu.test;

import com.wztedu.wztmybatis.sqlsession.WztConfiguration;
import org.junit.Test;

public class WztMybatisTest {

    @Test
    public void build() {
        WztConfiguration wztConfiguration = new WztConfiguration();

        wztConfiguration.build("wzt_mybatis.xml");
    }
}
