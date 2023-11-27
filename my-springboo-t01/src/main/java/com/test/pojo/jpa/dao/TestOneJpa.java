package com.test.pojo.jpa.dao;


import javax.persistence.*;

@Entity
@Table(name = "tb_test_one_jpa")
public class TestOneJpa {

    @Id //这是一个主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//自增主键
    @Column(name = "one_id", length = 22)
    public Integer id;

    @Column(name = "one_name", length = 100)
    public String name;

    @Column(name = "one_age", length = 22)
    public Integer age;

    @Column(name = "one_money", length = 22)
    public Double money;

    public String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "TestOneJpa{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                ", remark='" + remark + '\'' +
                '}';
    }
}
