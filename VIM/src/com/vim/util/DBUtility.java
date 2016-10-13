package com.vim.util;

import com.vim.dao.CarDAO;
import com.vim.dao.impl.JDBCCarDAO;
//todo's done
//TODO 1 Import appropriate packages based on TODOs 2 and 3

//Follow TODOs (if available)
/**
 * 
 * This is a DBUtility class
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */
public class DBUtility {
	private static CarDAO carDAO;
	//TODO 2 Declare a static reference dao of type CarDAO pointing to JDBCCarDAO instance
		
	/**
	 * @return	CarDAO a factory for creating DAO 
	 */
	public static void setCarDAO(CarDAO carDAO) {
		DBUtility.carDAO = carDAO;
	}
	public static CarDAO getCarDAO()
	{
		return carDAO; 
		//TODO 3 Implement a method getCarDAO which returns dao created in TODO 1
	}
}
