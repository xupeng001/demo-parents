package org.demo.mapper.restful.test.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CustomerInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3208773960260915126L;

    /**
     * 主键
     */
    private Long              cid;

    /**
     * 创建时间
     */
    private Date              gmtCreate;

    /**
     * 修改时间
     */
    private Date              gmtModified;

    /**
     * 个人姓名/企业名称
     */
    private String            name;

    /**
     * 0是个人 1是企业
     */
    private int               type;

    /**
     * 证件类型
     */
    private int               licensetype;

    /**
     * 证件号
     */
    private String            licensenumber;

    /**
     * 客户标识 0 普通客户 1分销客户
     */
    private int               customerTag;

    /**
     * 客户来源
     */
    private String            src;

    /**
     * 网址
     */
    private String            website;

    /**
     * 客户应用
     */
    private String            biz;

    /**
     * 客户备注
     */
    private String            note;

    /**
     * 客户介绍
     */
    private String            detail;

    /**
     * 是否冲突（0：未冲突 1：冲突）
     */
    private int               isConflict;
    /**
     * 合并到的CID
     */
    private Long              toCid;
    /**
     * 关键词（多个关键词用，分割）
     */
    private String            keyWord          = "";
    /**
     * 客户打标 0：无S标记 1：有S标记）
     */
    private int               SSign;
    /**
     * 客户类型（国内 国外） 手动添加或DW
     */
    private String            category;

    /**
     * 是否挑入当前客户机会为跟进中
     */
    private Boolean           isFollow;

    /**
     * 创建人工号
     */
    private String            lastModifiedEmpid;

    /**
     * 创建人名称
     */
    private String            lastModifiedName;

    /**
     * 风险等级
     */
    private int               riskLevel;

    /**
     * 客户来源
     */
    private String            origin;

    private Long              isDel;

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * @return the riskLevel
     */
    public int getRiskLevel() {
        return riskLevel;
    }

    /**
     * @param riskLevel the riskLevel to set
     */
    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    /**
     * setter for column 主键
     */
    public void setCid(Long cid) {
        this.cid = cid;
    }

    /**
     * getter for column 主键
     */
    public Long getCid() {
        return this.cid;
    }

    /**
     * setter for column 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * getter for column 创建时间
     */
    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    /**
     * setter for column 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * getter for column 修改时间
     */
    public Date getGmtModified() {
        return this.gmtModified;
    }

    /**
     * setter for column 个人姓名/企业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter for column 个人姓名/企业名称
     */
    public String getName() {
        return this.name;
    }

    /**
     * setter for column 0是个人 1是企业
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     * getter for column 0是个人 1是企业
     */
    public int getType() {
        return this.type;
    }

    /**
     * setter for column 证件类型
     */
    public void setLicensetype(int licensetype) {
        this.licensetype = licensetype;
    }

    /**
     * getter for column 证件类型
     */
    public int getLicensetype() {
        return this.licensetype;
    }

    /**
     * setter for column 证件号
     */
    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    /**
     * getter for column 证件号
     */
    public String getLicensenumber() {
        return this.licensenumber;
    }

    /**
     * @return the customerTag 客户标签
     */
    public int getCustomerTag() {
        return customerTag;
    }

    /**
     * @param customerTag the customerTag to set
     */
    public void setCustomerTag(int customerTag) {
        this.customerTag = customerTag;
    }

    /**
     * setter for column 客户来源
     */
    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * getter for column 客户来源
     */
    public String getSrc() {
        return this.src;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBiz() {
        return biz;
    }

    public void setBiz(String biz) {
        this.biz = biz;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return the isConflict
     */
    public int getIsConflict() {
        return isConflict;
    }

    /**
     * @param isConflict the isConflict to set
     */
    public void setIsConflict(int isConflict) {
        this.isConflict = isConflict;
    }

    /**
     * @return the toCid
     */
    public Long getToCid() {
        return toCid;
    }

    /**
     * @param toCid the toCid to set
     */
    public void setToCid(Long toCid) {
        this.toCid = toCid;
    }

    /**
     * @return the keyWord
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * @param keyWord the keyWord to set
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    /**
     * @return the sSign
     */
    public int getSSign() {
        return SSign;
    }

    /**
     * @param sSign the sSign to set
     */
    public void setSSign(int sSign) {
        SSign = sSign;
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the isFollow
     */
    public Boolean getIsFollow() {
        return isFollow;
    }

    /**
     * @param isFollow the isFollow to set
     */
    public void setIsFollow(Boolean isFollow) {
        this.isFollow = isFollow;
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
     * @return the lastModifiedName
     */
    public String getLastModifiedName() {
        return lastModifiedName;
    }

    /**
     * @param lastModifiedName the lastModifiedName to set
     */
    public void setLastModifiedName(String lastModifiedName) {
        this.lastModifiedName = lastModifiedName;
    }

    public Long getIsDel() {
        return isDel;
    }

    public void setIsDel(Long isDel) {
        this.isDel = isDel;
    }

}
