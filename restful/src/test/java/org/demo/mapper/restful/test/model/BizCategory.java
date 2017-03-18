package org.demo.mapper.restful.test.model;

public class BizCategory {

    private String  bizCategorySub;
    private String  bizCategory;
    private Integer cid;

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setBizCategory(String bizCategory) {
        this.bizCategory = bizCategory;
    }

    public String getBizCategory() {
        return bizCategory;
    }

    public void setBizCategorySub(String bizCategorySub) {
        this.bizCategorySub = bizCategorySub;
    }

    public String getBizCategorySub() {
        return bizCategorySub;
    }
}
