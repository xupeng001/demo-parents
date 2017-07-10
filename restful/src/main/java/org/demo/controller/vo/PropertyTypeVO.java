package org.demo.controller.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PropertyTypeVO {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date time;
	private Long num;

	@Override
	public String toString() {
		return "PropertyTypeVO [time=" + time + ", num=" + num + "]";
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public PropertyTypeVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyTypeVO(Date time, Long num) {
		super();
		this.time = time;
		this.num = num;
	}

}
