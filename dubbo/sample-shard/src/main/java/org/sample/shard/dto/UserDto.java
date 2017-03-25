package org.sample.shard.dto;

import java.io.Serializable;

/**
 * 类UserDto.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月25日 上午11:51:33
 */
public class UserDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1259827485002774544L;
    /* 姓名 */
    private String            name;
    /* 工号 */
    private String            emplyId;

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

    public UserDto() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserDto(String name, String emplyId) {
        super();
        this.name = name;
        this.emplyId = emplyId;
    }

}
