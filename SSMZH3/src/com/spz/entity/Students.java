package com.spz.entity;


public class Students {
	private Integer stu_id;
	j
	private String stu_status;
	private Integer class_id;
	
	
	private String maxBirth;
	private String minBirth;
	
	private Integer page;
	private Integer rows;
	
	private Classes classes;
	
	public Integer getStu_id() {
		return stu_id;
	}
	public void setStu_id(Integer stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getStu_status() {
		return stu_status;
	}
	public void setStu_status(String stu_status) {
		this.stu_status = stu_status;
	}
	public Integer getClass_id() {
		return class_id;
	}
	public void setClass_id(Integer class_id) {
		this.class_id = class_id;
	}
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	
	public Classes getClasses() {
		return classes;
	}
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	
	
	public String getMaxBirth() {
		return maxBirth;
	}
	public void setMaxBirth(String maxBirth) {
		this.maxBirth = maxBirth;
	}
	public String getMinBirth() {
		return minBirth;
	}
	public void setMinBirth(String minBirth) {
		this.minBirth = minBirth;
	}
	@Override
	public String toString() {
		return "Students [stu_id=" + stu_id + ", stu_name=" + stu_name + ", sex=" + sex + ", mtel=" + mtel + ", qq="
				+ qq + ", address=" + address + ", birthday=" + birthday + ", stu_status=" + stu_status + ", class_id="
				+ class_id + ", maxBirth=" + maxBirth + ", minBirth=" + minBirth + ", page=" + page + ", rows=" + rows
				+ ", classes=" + classes + "]";
	}
	
	
	
	
	
}
