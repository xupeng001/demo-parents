package com.example.json;

/**
 * 类DemoBean.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年6月23日 上午10:55:36
 */
public class DemoBean {

    private String name;
    private String nickName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    

    public DemoBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public DemoBean(String name, String nickName) {
        super();
        this.name = name;
        this.nickName = nickName;
    }
    
}
