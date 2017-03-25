package org.sample.shard.params;

import java.io.Serializable;

/**
 * 类UserParam.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月25日 上午11:55:22
 */
public class UserParam implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1047237025458239752L;
    /* 姓名 */
    private String name;
    /* 工号 */
    private String emplyId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmplyId() {
        return emplyId;
    }

    public void setEmplyId(String emplyId) {
        this.emplyId = emplyId;
    }
}
