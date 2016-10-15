package com.flp.ems.domain;

public class Role {
	private static int count =0;
	private int id;
	private String name, desc;
	public Role(int id, String name, String desc) {
		this.id = ++count;
		this.name = name;
		this.desc = desc;
	}
	public String getDesc() {
		return desc;
	}public int getId() {
		return id;
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
