package com.neuedu.pojo;

    /*数据库的属性类*/

public class Test {
    private Integer id ;//装箱
    private String tname ;

    public Test() {

    }

    public Test(Integer id, String tname) {
        this.id = id;
        this.tname = tname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public String toString() {
        return "test{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                '}';
    }
}
