package org.reflect.demo;

import java.io.Serializable;

import com.sun.istack.internal.NotNull;

public class Student extends Persion implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 169089621260109883L;

    /**
     * 学号
     */
    @NotNull
    private Long  stuId;

    public String className;

    public Long getStuId() {
        return stuId;
    }

    @Deprecated
    public void setStuId(Long stuId) {
        this.stuId = stuId;
    }

    protected void protectedMethod() {

    }

    @Override
    public String toString() {
        return "Student [stuId=" + stuId + ", className=" + className + "]";
    }

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(Long stuId, String className) {
        super();
        this.stuId = stuId;
        this.className = className;
    }
    
    

}
