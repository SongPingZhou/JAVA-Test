package com.spz.entity;

public class Classes {
	private Integer class_id;
	private String class_name;
	private Integer class_status;
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	public String getClass_name() {
		return class_name;
	}
	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
	public Integer getClass_status() {
		return class_status;
	}
	public void setClass_status(Integer class_status) {
		this.class_status = class_status;
	}
	@Override
	public String toString() {
		return "Classes [class_id=" + class_id + ", class_name=" + class_name + ", class_status=" + class_status + "]";
	}
	
}
