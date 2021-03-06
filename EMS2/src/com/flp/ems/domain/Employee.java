package com.flp.ems.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee implements Cloneable {
	private String name, email, address;
	private long phone;
	private int deptid, projid, roleid, empid;
	private Date dob, doj;

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

	public Employee(int empid, String name, String email, long phone, String dob, String doj, String address, int deptid,
			int projid, int roleid) {
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.deptid = deptid;
		this.projid = projid;
		this.roleid = roleid;
		this.setDob(dob);
		this.setDoj(doj);
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
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
	

	public void setDob(String dob) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		try {
			this.dob = df.parse(dob);
		} catch (ParseException e) {
			System.out.println("Invalid Date");
			e.printStackTrace();
		}
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	

	public void setDoj(String doj) {
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		try {
			this.doj = df.parse(doj);
		} catch (ParseException e) {
			System.out.println("Invalid Date");
			e.printStackTrace();
		}
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
		return String.format("%3d %10s %30s %4d %4d %4d", empid, name, email, deptid, projid, roleid);
	}

}
