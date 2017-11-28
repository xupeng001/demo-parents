package org.io.netty;

import java.io.Serializable;
import java.util.UUID;

public class SubscribeReq implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 549696177296064029L;

    private String            name;

    private String            reqId            = UUID.randomUUID().toString();

    private String            desp;

    public String getDesp() {
        return desp;
    }

    public void setDesp(String desp) {
        this.desp = desp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    @Override
    public String toString() {
        return "SubscribeReq [name=" + name + ", reqId=" + reqId + ", desp=" + desp + "]";
    }

}
