package com.flp.ems.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test");
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static void close(Object... objects) {
		try {
			for (Object object : objects) {
				if (null != object) {
					if (object instanceof Connection) {
						((Connection) object).close();
						// System.out.println("connection closed");
					} else if (object instanceof Statement) {
						((Statement) object).close();
						// System.out.println("statement clsoe");
					} else if (object instanceof ResultSet) {
						((ResultSet) object).close();
					} else {
						// System.out.println("unable to close");
					}
				}
			}
		} catch (Exception e) {

		}
	}
}
