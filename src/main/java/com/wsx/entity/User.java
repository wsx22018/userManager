package com.wsx.entity;


import java.util.Date;
import java.util.Map;

import com.alibaba.druid.support.monitor.annotation.MTable;

/**
 * 用户实体类
 * @author wsx
 *
 */
public class User {
	/**
	 * 主键ID
	 */
	private int id;
	
	/**
	 * 用户名称
	 */
	private String name;
	
	/**
	 * 年龄
	 */
	private int age;
	
	/**
	 * 性别
	 */
	private int sex;
	
	/**
	 * e-mail邮箱
	 */
	private String email;
	
	/**
	 * 创建时间
	 */
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id 
				+ ", name=" + name 
				+ ", age=" + age 
				+ ", sex=" + sex 
				+ ", email=" + email
				+ ", createTime=" 
				+ createTime + "]";
	}
}
