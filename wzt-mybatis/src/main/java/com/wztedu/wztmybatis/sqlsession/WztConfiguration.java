package com.wztedu.wztmybatis.sqlsession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author xiaotao
 * @version 1.0
 * 读取xml文件，建立连接
 */
public class WztConfiguration {

    // 属性-类加载器
    private static ClassLoader classLoader = ClassLoader.getSystemClassLoader();

    // 读取xml文件信息，并处理
    public Connection build(String resource) {

        Connection connection = null;

        try {
            // 加载配置 wzt_mybatis.xml 获取到对应的InputStream
            InputStream stream = classLoader.getResourceAsStream(resource);

            // 解析 wzt_mybatis.xml => dom4j的知识
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(stream);
            // 获取到 wzt_mybatis.xml 根元素 <database>
            Element root = document.getRootElement();
            System.out.println("root=" + root);
            // 解析 root 元素，返回 Connection => 单独的编写一个方法
            connection = evalDataSource(root);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }

    // 方法会解析 wzt_mybatis.xml 信息，并返回 Connection
    private Connection evalDataSource(Element node) {

        if (!"database".equals(node.getName())) {
            throw new RuntimeException("root 节点应该是<database>");
        }

        // 连接 db 的必要参数
        String driverClassName = null;
        String url = null;
        String username = null;
        String password = null;

        // 遍历 node 下的子节点，获取属性值
        for (Object item : node.elements("property")) {
            Element i = (Element) item;  // i 就是 property 节点
            String name = i.attributeValue("name");
            String value = i.attributeValue("value");

            // 判断是否得到 name 和 value
            if (name == null || value == null) {
                throw new RuntimeException("property 节点没有设置 name 或 value 属性");
            }

            switch (name) {
                case "url":
                    url = value;
                    break;
                case "username":
                    username = value;
                    break;
                case "password":
                    password = value;
                    break;
                case "driverClassName":
                    driverClassName = value;
                    break;
                default:
                    throw new RuntimeException("属性名没有匹配到...");
            }
        }

        Connection connection = null;

        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
