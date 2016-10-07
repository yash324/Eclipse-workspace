package com.flp.ems.domain;

public class Project {
	private int id;
	private static int count = 0;
	private String name, desc;
	private Department dept;

	public Project(String name, String desc, Department dept) {
		this.name = name;
		this.desc = desc;
		this.dept = dept;
		this.id = ++count;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	public String getName() {
		return name;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setName(String name) {
		this.name = name;
	}
}
