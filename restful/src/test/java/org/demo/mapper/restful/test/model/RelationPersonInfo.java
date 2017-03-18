package org.demo.mapper.restful.test.model;

import java.io.Serializable;

/**
 * 类CustomerArchitectInfo.java的实现描述：TODO 类实现描述
 */
public class RelationPersonInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 3629811819186507936L;

    /**
     * 主键
     */
    private long              id;

    /**
     * 客户ID
     */
    private long              cid;

    /**
     * 架构师工号
     */
    private String            empId;

    /**
     * 架构师姓名
     */
    private String            name;

    /**
     * 主键
     */
    private String            lastModifiedEmpid;

    /**
     * 类型 0：架构师 1：地方商务 2：服务经理
     */
    private int               type;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the cid
     */
    public long getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(long cid) {
        this.cid = cid;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastModifiedEmpid
     */
    public String getLastModifiedEmpid() {
        return lastModifiedEmpid;
    }

    /**
     * @param lastModifiedEmpid the lastModifiedEmpid to set
     */
    public void setLastModifiedEmpid(String lastModifiedEmpid) {
        this.lastModifiedEmpid = lastModifiedEmpid;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

}
