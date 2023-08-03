package com.wztedu.entity;

import java.util.Date;

/**
 * @author xiaotao
 * @version 1.0
 */
public class Monster {
    private Integer id;
    private Integer age;
    private String name;
    private String email;
    private Date birthday;
    private double salary;
    private Integer gender;

    public Monster() {
    }

    public Monster(Integer id, Integer age, String name, String email, Date birthday, double salary, Integer gender) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.salary = salary;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", salary=" + salary +
                ", gender=" + gender +
                '}';
    }
}
