package org.design.prototype.bean;

import java.io.Serializable;

public class Account implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -1331620842568187565L;

    private String            empId;

    private String            mail;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Account() {
        super();
    }

    public Account(String empId, String mail) {
        super();
        this.empId = empId;
        this.mail = mail;
    }

}
