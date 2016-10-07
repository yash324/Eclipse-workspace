package com.flp.ems.domain;

import java.util.Date;

public class Employee implements Cloneable{
	private static int count = 0;
	private String name, email, address;
	private long phone;
	private int deptid, projid, roleid, empid;

	public int getProjid() {
		return projid;
	}
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	

	public void setProjid(int projid) {
		this.projid = projid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	private Date dob, doj;

	public Employee(String name, String email, long phone, Date dob, Date doj, String address, int deptid, int projid,
			int roleid) {
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.deptid = deptid;
		this.projid = projid;
		this.roleid = roleid;
		this.dob = dob;
		this.doj = doj;
		this.empid = ++count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public int getEmpid() {
		return empid;
	}

	public Date getDob() {
		return dob;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public boolean equals(Object obj) {
		return this.email.equals(((Employee) obj).email);
	}

	@Override
	public int hashCode() {
		return this.email.hashCode();
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	@Override
	public String toString() {
		String val = String.format("%4d %25s %10s %4d %4d %4d", this.empid, this.email, this.name, this.roleid, this.deptid, this.projid);
		return val;
	}
	
}
