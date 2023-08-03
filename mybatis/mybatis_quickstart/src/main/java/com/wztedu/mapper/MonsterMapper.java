package com.wztedu.mapper;

import com.wztedu.entity.Monster;

import java.util.List;

public interface MonsterMapper {

    // 添加Monster
    public void addMonster(Monster monster);

    // 根据id删除一个Monster
    public void delMonster(Integer id);

    // 修改 Monster
    public void updateMonster(Monster monster);

    // 查询-根据 id
    public Monster getMonsterById(Integer id);

    //查询所有的 Monster
    public List<Monster> findAllMonster();
}
