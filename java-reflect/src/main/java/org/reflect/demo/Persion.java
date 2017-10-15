package org.reflect.demo;

import java.io.Serializable;

public class Persion implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = -8050349756611663247L;
    private int   age;
    public String name;
    protected int sex;
    /**
     * 私有方法測試
     */
    private void name(){
        
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persion [age=" + age + ", name=" + name + ", sex=" + sex + "]";
    }

    public Persion() {
        super();
        // TODO Auto-generated constructor stub
    }

}
