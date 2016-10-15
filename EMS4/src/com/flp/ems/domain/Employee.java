package com.flp.ems.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Employee {
	private String name, email, address;
	private long phone;
	private int deptid, projid, roleid, empid;
	private Date dob, doj;

	public Employee() {
		this.empid = -1;
	}

	public Employee(int empid, String name, String email, long phone, String dob, String doj, String address,
			int deptid, int projid, int roleid) {
		this.empid = empid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.setDob(dob);
		this.setDoj(doj);
		this.address = address;
		this.deptid = deptid;
		this.projid = projid;
		this.roleid = roleid;
	}

	@Override
	public boolean equals(Object obj) {
		return this.email.equals(((Employee) obj).email);
	}

	public String getAddress() {
		if (this.address == null)
			return "";
		return address;
	}

	public int getDeptid() {
		return deptid;
	}

	public String getDob() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (this.dob == null)
			return "";
		return df.format(this.dob);
	}

	public String getDoj() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		if (this.doj == null)
			return "";
		return df.format(this.doj);
	}

	public String getEmail() {
		if (this.email == null)
			return "";
		return email;
	}

	public int getEmpid() {
		return empid;
	}

	public String getName() {
		if (this.name == null)
			return "";
		return name;
	}

	public long getPhone() {
		return phone;
	}

	public int getProjid() {
		return projid;
	}

	public int getRoleid() {
		return roleid;
	}

	@Override
	public int hashCode() {
		return this.email.hashCode();
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public void setDob(String dob) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.dob = df.parse(dob);
		} catch (ParseException e) {
			System.out.println("Invalid Date");
			e.printStackTrace();
		}
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public void setDoj(String doj) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.doj = df.parse(doj);
		} catch (ParseException e) {
			System.out.println("Invalid Date");
			e.printStackTrace();
		}
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public void setProjid(int projid) {
		this.projid = projid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

}
