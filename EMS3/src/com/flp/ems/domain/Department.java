package com.flp.ems.domain;

public class Department {
	private int id;
	private String name, desc;
	private static int count;

	public Department(String name, String desc) {
		this.name = name;
		this.desc = desc;
		this.id = ++count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

}
