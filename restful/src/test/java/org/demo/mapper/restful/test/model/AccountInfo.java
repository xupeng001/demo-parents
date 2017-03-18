package org.demo.mapper.restful.test.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 账号信息
 */
public class AccountInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5583926303770728736L;

    /**
     * 主键 阿里云uid
     */
    private Long              id;

    /**
     * 个人姓名/企业名称
     */
    private String            name;

    /**
     * 类型 0是个人 1是企业
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
     * 云账号邮箱
     */
    private String            aliyunID;
    /**
     * 客户类型（国内 国外）
     */
    private String            category;
    /**
     * 账号 标识
     */
    private int               customerTag;

    /**
     * 最后操作人
     */
    private String            lastModifiedEmpid;

    /**
     * 是否有效 0：有效 ！=0 无效
     */
    private long              isDel;

    /**
     * 是否认证
     */
    private int               isCertification;

    /**
     * 安全手机号
     */
    private String            securityMobile;

    /**
     * 创建时间
     */
    private Date              gmtCreate;
    /**
     * 最后修改时间
     */

    private Date              gmtModified;

    /**
     * 联系电话，普通电话号码
     */
    private String            phone;

    /**
     * 邮件地址。该地址是用户填写的普通邮件地址信息，并非该用户的aliyun.com邮件地址
     */
    private String            email;

    /** 海外注册国籍代码 */
    private String            nationalityCode;                         // 海外注册国籍代码

    /**
     * 城市
     */
    private String            city;

    /**
     * 现居地址
     */
    private String            address;
    /**
     * 传真号码
     */
    private String            fax;

    /**
     * 省份
     */
    private String            province;

    /**
     * 认证来源(待处理)
     */
    private String            certifiedFrom;

    /**
     * 认证入库时间
     */
    private Date              certifiedTime;

    /**
     * any string, when register account in page, src parameter in url
     */
    private String            src;

    /**
     * 关联的集团统一ID
     */
    private String            havanaId;
    /** 首选语言 */
    private String            preferredLanguage;

    private String            site;
    /**
     * appKey, when create account, come from which app
     */
    private String            own;
    /**
     * 账号的昵称
     */
    private String            nickName;

    /**
     * 所属partner pk
     */
    private String            partnerPk;

    /**
     * 所属bid
     */
    private String            bid;

    /**
     * 主行业应用
     */

    private String            bizCategory;
    /**
     * 二级行业应用
     */

    private String            bizCategorySub;

    /**
     * 客户分类
     */
    private String            customerCategory;

    /**
     * @return the is_certification
     */
    public int getIsCertification() {
        return isCertification;
    }

    /**
     * @param is_certification the is_certification to set
     */
    public void setIsCertification(int isCertification) {
        this.isCertification = isCertification;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
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

    /**
     * @return the licensetype
     */
    public int getLicensetype() {
        return licensetype;
    }

    /**
     * @param licensetype the licensetype to set
     */
    public void setLicensetype(int licensetype) {
        this.licensetype = licensetype;
    }

    /**
     * @return the licensenumber
     */
    public String getLicensenumber() {
        return licensenumber;
    }

    /**
     * @param licensenumber the licensenumber to set
     */
    public void setLicensenumber(String licensenumber) {
        this.licensenumber = licensenumber;
    }

    /**
     * @return the aliyunID
     */
    public String getAliyunID() {
        return aliyunID;
    }

    /**
     * @param aliyunID the aliyunID to set
     */
    public void setAliyunID(String aliyunID) {
        this.aliyunID = aliyunID;
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
     * @return the customerTag
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
     * @return the isDel
     */
    public long getIsDel() {
        return isDel;
    }

    /**
     * @param isDel the isDel to set
     */
    public void setIsDel(long isDel) {
        this.isDel = isDel;
    }

    /**
     * @return the securityMobile
     */
    public String getSecurityMobile() {
        return securityMobile;
    }

    /**
     * @param securityMobile the securityMobile to set
     */
    public void setSecurityMobile(String securityMobile) {
        this.securityMobile = securityMobile;
    }

    /**
     * @return the gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate the gmtCreate to set
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return the gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified the gmtModified to set
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCertifiedFrom() {
        return certifiedFrom;
    }

    public void setCertifiedFrom(String certifiedFrom) {
        this.certifiedFrom = certifiedFrom;
    }

    public Date getCertifiedTime() {
        return certifiedTime;
    }

    public void setCertifiedTime(Date certifiedTime) {
        this.certifiedTime = certifiedTime;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getHavanaId() {
        return havanaId;
    }

    public void setHavanaId(String havanaId) {
        this.havanaId = havanaId;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getOwn() {
        return own;
    }

    public void setOwn(String own) {
        this.own = own;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPartnerPk() {
        return partnerPk;
    }

    public void setPartnerPk(String partnerPk) {
        this.partnerPk = partnerPk;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBizCategory() {
        return bizCategory;
    }

    public void setBizCategory(String bizCategory) {
        this.bizCategory = bizCategory;
    }

    public String getBizCategorySub() {
        return bizCategorySub;
    }

    public void setBizCategorySub(String bizCategorySub) {
        this.bizCategorySub = bizCategorySub;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public void setCustomerCategory(String customerCategory) {
        this.customerCategory = customerCategory;
    }

}
