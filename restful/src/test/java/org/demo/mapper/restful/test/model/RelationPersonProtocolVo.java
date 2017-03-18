package org.demo.mapper.restful.test.model;

public class RelationPersonProtocolVo implements RestfulProtocolVo {

    /**
     * 
     */
    private static final long serialVersionUID = 5041655776044838406L;

    private String            empId;
    private String            name;
    private Integer           type;

    /**
     * 客户ID
     */
    private long              cid;

    public void setCid(long cid) {
        this.cid = cid;
    }

    public long getCid() {
        return cid;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }

    public Integer getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
