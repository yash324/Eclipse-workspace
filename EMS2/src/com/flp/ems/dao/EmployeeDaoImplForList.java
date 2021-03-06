package com.flp.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flp.ems.domain.*;
import com.flp.ems.util.DBUtil;

public class EmployeeDaoImplForList implements IEmployeeDao {
	private static Connection conn;

	@Override
	public boolean AddEmployee(Employee emp) {
		boolean flag = false;
		PreparedStatement insertStat = null;
		try {
			conn = DBUtil.getConnection();
			insertStat = conn.prepareStatement(
					"INSERT INTO employee (name, email, phone, dob, doj, addr, deptid, projid, roleid) VALUES (? , ? , ? , ? , ? , ? , ? , ? , ?)");
			insertStat.setString(1, emp.getName());
			insertStat.setString(2, emp.getEmail());
			insertStat.setLong(3, emp.getPhone());
			insertStat.setDate(4, new java.sql.Date(emp.getDob().getTime()));
			insertStat.setDate(5, new java.sql.Date(emp.getDoj().getTime()));
			insertStat.setString(6, emp.getAddress());
			insertStat.setInt(7, emp.getDeptid());
			insertStat.setInt(8, emp.getProjid());
			insertStat.setInt(9, emp.getRoleid());
			insertStat.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(insertStat, conn);
		}
		return flag;
	}

	@Override
	public ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		ResultSet result = null;
		PreparedStatement getStat = null;
		try {
			conn = DBUtil.getConnection();
			getStat = conn.prepareStatement("SELECT * from employee");
			result = getStat.executeQuery();
			while (result.next()) {
				Employee emp = new Employee();
				emp.setEmpid(result.getInt(1));
				emp.setName(result.getString(2));
				emp.setEmail(result.getString(3));
				emp.setPhone(result.getLong(4));
				emp.setDob(result.getDate(5));
				emp.setDoj(result.getDate(6));
				emp.setAddress(result.getString(7));
				emp.setDeptid(result.getInt(8));
				emp.setProjid(result.getInt(9));
				emp.setRoleid(result.getInt(10));
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(result, getStat, conn);
		}
		return empList;
	}

	@Override
	public boolean ModifyEmployee(Employee emp) {
		boolean flag = false;
		PreparedStatement updateStat = null;
		try {
			conn = DBUtil.getConnection();
			updateStat = conn.prepareStatement(
					"UPDATE employee SET name=?, email=?, phone=?, dob=?, doj=?, addr=?, deptid=?, projid=?, roleid=? WHERE empid = ?");
			updateStat.setString(1, emp.getName());
			updateStat.setString(2, emp.getEmail());
			updateStat.setLong(3, emp.getPhone());
			updateStat.setDate(4, new java.sql.Date(emp.getDob().getTime()));
			updateStat.setDate(5, new java.sql.Date(emp.getDoj().getTime()));
			updateStat.setString(6, emp.getAddress());
			updateStat.setInt(7, emp.getDeptid());
			updateStat.setInt(8, emp.getProjid());
			updateStat.setInt(9, emp.getRoleid());
			updateStat.setInt(10, emp.getEmpid());
			updateStat.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(updateStat, conn);
		}
		return flag;
	}

	@Override
	public boolean RemoveEmployee(int id) {
		ResultSet result = null;
		PreparedStatement remStat = null;
		boolean flag = false;
		try {
			conn = DBUtil.getConnection();
			remStat = conn.prepareStatement("DELETE from employee WHERE empid = ?");
			remStat.setInt(1, id);
			remStat.execute();
			flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(result, remStat, conn);
		}
		return flag;
	}

	@Override
	public Employee SearchEmployee(int id) {
		ResultSet result = null;
		PreparedStatement searchStat = null;
		boolean flag = false;
		Employee emp = new Employee();
		try {
			conn = DBUtil.getConnection();
			searchStat = conn.prepareStatement("select * from employee where empid = ?");
			searchStat.setInt(1, id);
			result = searchStat.executeQuery();
			if (result.next()) {
				emp.setEmpid(result.getInt(1));
				emp.setName(result.getString(2));
				emp.setEmail(result.getString(3));
				emp.setPhone(result.getLong(4));
				emp.setDob(result.getDate(5));
				emp.setDoj(result.getDate(6));
				emp.setAddress(result.getString(7));
				emp.setDeptid(result.getInt(8));
				emp.setProjid(result.getInt(9));
				emp.setRoleid(result.getInt(10));
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(result, searchStat, conn);
		}
		if (flag == false)
			return null;
		else
			return emp;
	}
}
