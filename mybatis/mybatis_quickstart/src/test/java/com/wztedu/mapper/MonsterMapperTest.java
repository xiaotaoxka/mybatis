package com.wztedu.mapper;

import com.wztedu.entity.Monster;
import com.wztedu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class MonsterMapperTest {
    // 属性
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    // 编写方法完成初始化任务

    @Before
    public void init() {
        // 获取到 sqlSession
        sqlSession = MybatisUtils.getSqlSession();
        // 获得 MonsterMapper 对象
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);

        System.out.println("monsterMapper= " + monsterMapper.getClass());
    }

    @Test
    public void addMonster() {

        for (int i = 0; i < 2; i++) {
            Monster monster = new Monster();
            monster.setAge(10 + i);
            monster.setBirthday(new Date());
            monster.setEmail("xiaotao@qq.com");
            monster.setGender(1);
            monster.setName("迷糊精-" + i);
            monster.setSalary(1000 + i * 10);
            monsterMapper.addMonster(monster);

            System.out.println("添加对象--" + monster);
            System.out.println("添加到表中后，自增长的id=" + monster.getId());
        }

        // 如果是增删改，需要提交事务
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("保存成功");
    }

    @Test
    public void delMonster() {
        monsterMapper.delMonster(4);

        // 如果是增删改，需要提交事务
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("删除成功");
    }

    @Test
    public void updateMonster() {
        Monster monster = new Monster();
        monster.setAge(50);
        monster.setBirthday(new Date());
        monster.setEmail("xiaotao@qq.com");
        monster.setGender(0);
        monster.setName("老鼠精new");
        monster.setSalary(2000);
        monster.setId(3);

        monsterMapper.updateMonster(monster);

        // 如果是增删改，需要提交事务
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("修改成功");
    }

    @Test
    public void getMonsterById() {

        Monster monster = monsterMapper.getMonsterById(1);
        System.out.println("monster=" + monster);

        // 如果是增删改，需要提交事务
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("查询成功");
    }

    @Test
    public void findAllMonster() {
        List<Monster> allMonster = monsterMapper.findAllMonster();
        for (Monster monster : allMonster) {
            System.out.println("monster-" + monster);
        }

        if (sqlSession != null) {
            sqlSession.close();
        }

        System.out.println("查询成功");
    }
}
