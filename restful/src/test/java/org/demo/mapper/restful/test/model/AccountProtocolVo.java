package org.demo.mapper.restful.test.model;


public class AccountProtocolVo implements RestfulProtocolVo {

    /**
     * 
     */
    private static final long serialVersionUID = 3460951106636254393L;

    private String            aliyunID;
    private String            aliyunPK;

    public String getAliyunID() {
        return aliyunID;
    }

    public String getAliyunPK() {
        return aliyunPK;
    }

    public void setAliyunID(String aliyunID) {
        this.aliyunID = aliyunID;
    }

    public void setAliyunPK(String aliyunPK) {
        this.aliyunPK = aliyunPK;
    }
}
