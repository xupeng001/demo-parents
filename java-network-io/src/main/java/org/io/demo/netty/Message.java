package org.io.demo.netty;

import java.io.Serializable;

public class Message implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String            name;

    public Message(String name) {
        super();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Message [name=" + name + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
