package com.wztedu.wztmybatis.sqlsession;

import com.wztedu.entity.Monster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WztExecutor implements Executor {

    // 属性
    private WztConfiguration wztConfiguration = new WztConfiguration();

    /**
     * @param sql
     * @param parameter
     * @param <T>
     * @return
     */
    @Override
    public <T> T query(String sql, Object parameter) {
        // 得到连接 Connection
        Connection connection = getConnection();

        // 查询返回的结果
        ResultSet set = null;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, parameter.toString());
            set = preparedStatement.executeQuery();

            // 把 set 数据封装到对象 - monster
            Monster monster = new Monster();

            // 遍历结果集
            while (set.next()) {
                monster.setId(set.getInt("id"));
                monster.setName(set.getString("name"));
                monster.setEmail(set.getString("email"));
                monster.setAge(set.getInt("age"));
                monster.setGender(set.getInt("gender"));
                monster.setBirthday(set.getDate("birthday"));
                monster.setSalary(set.getDouble("salary"));
            }

            return (T) monster;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (set != null) {
                    set.close();
                }

                if (preparedStatement != null) {
                    preparedStatement.close();
                }

                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    // 编写方法，通过 WztConfiguration 对象，返回连接
    private Connection getConnection() {
        Connection connection = wztConfiguration.build("wzt_mybatis.xml");
        return connection;
    }
}
