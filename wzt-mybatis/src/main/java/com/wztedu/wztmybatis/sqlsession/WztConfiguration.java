package com.wztedu.wztmybatis.sqlsession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.sql.Connection;

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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 方法会解析 wzt_mybatis.xml 信息，并返回 Connection
    private Connection evalDataSource(Element node) {


        return null;
    }
}
