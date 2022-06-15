package cn.wjs.model;


import com.alibaba.fastjson.JSON;

public class User {

    public static void main(String[] args) {
        String str = "{\"id\":1, \"name\":\"zhangsan\"}";
        User user = JSON.parseObject(str, User.class);
        System.out.println(user);
    }
    private Integer id;

    private String name;

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
}
