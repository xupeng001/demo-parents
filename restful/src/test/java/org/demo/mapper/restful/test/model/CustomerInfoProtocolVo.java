package org.demo.mapper.restful.test.model;

import java.util.List;

import org.demo.mapper.restful.annotations.ClassAddressing;
import org.demo.mapper.restful.annotations.FieldAddressing;

/**
 * 类CustomerInfoProtocolVo.java的实现描述：TODO 类实现描述
 * 
 * @author wb199502 2017年3月2日 下午2:51:48
 */
public class CustomerInfoProtocolVo implements RestfulProtocolVo {

    /**
     * 
     */
    private static final long              serialVersionUID = -4600602514053529566L;

    private String                         cid;
    @ClassAddressing(sourceClazz = AccountInfo.class, targetClazz = AccountProtocolVo.class)
    private List<AccountProtocolVo>        uids;
    @FieldAddressing(clazz = CustomerInfo.class, fieldName = "name")
    private String                         customerName;
    private String                         bizCategorySub;
    private String                         bizCategory;
    @ClassAddressing(sourceClazz = RelationPersonInfo.class, targetClazz = RelationPersonProtocolVo.class)
    private List<RelationPersonProtocolVo> businessManager;
    private List<RelationPersonProtocolVo> serviceManager;
    private List<RelationPersonProtocolVo> architectManger;

    public void setBizCategory(String bizCategory) {
        this.bizCategory = bizCategory;
    }

    public String getBizCategory() {
        return bizCategory;
    }

    public void setArchitectManger(List<RelationPersonProtocolVo> architectManger) {
        this.architectManger = architectManger;
    }

    public void setBusinessManager(List<RelationPersonProtocolVo> businessManager) {
        this.businessManager = businessManager;
    }

    public void setServiceManager(List<RelationPersonProtocolVo> serviceManager) {
        this.serviceManager = serviceManager;
    }

    public List<RelationPersonProtocolVo> getArchitectManger() {
        return architectManger;
    }

    public List<RelationPersonProtocolVo> getBusinessManager() {
        return businessManager;
    }

    public List<RelationPersonProtocolVo> getServiceManager() {
        return serviceManager;
    }

    public void setBizCategorySub(String bizCategorySub) {
        this.bizCategorySub = bizCategorySub;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setUids(List<AccountProtocolVo> uids) {
        this.uids = uids;
    }

    public String getBizCategorySub() {
        return bizCategorySub;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCid() {
        return cid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public List<AccountProtocolVo> getUids() {
        return uids;
    }
}
