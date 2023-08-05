package com.wztedu.wztmybatis.sqlsession;

public interface Executor {

    // 泛型方法
    public <T> T query(String statement, Object parameter);
}
