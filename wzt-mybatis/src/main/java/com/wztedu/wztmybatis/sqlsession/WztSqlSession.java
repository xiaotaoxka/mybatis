package com.wztedu.wztmybatis.sqlsession;

/**
 * WztSqlSession: 搭建Configuration(连接) 和 Executor之间的桥梁
 */
public class WztSqlSession {
    // 属性
    // 执行器
    private Executor executor = new WztExecutor();
    // 配置
    private WztConfiguration wztConfiguration = new WztConfiguration();

    // 编写方法 SelectOne 返回一条记录 --> 对象
    public <T> T selectOne(String statement, Object parameter) {

        return executor.query(statement, parameter);
    }
}
