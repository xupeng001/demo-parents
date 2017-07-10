package com.demo.bean;

import java.io.Serializable;

/**
 * @author xupeng
 *
 */
public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4283334801995640409L;
	private int id;
	private String title;
	private String context;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Message(String title, String context) {
		super();
		this.title = title;
		this.context = context;
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

}
