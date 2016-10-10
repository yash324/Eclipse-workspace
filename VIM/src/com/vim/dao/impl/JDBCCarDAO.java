package com.vim.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.vim.dao.CarDAO;
import com.vim.dto.CarDTO;
import com.vim.util.ServiceLocator;
import com.vim.util.ServiceLocatorException;
//todos complete
//TODO 1 Import appropriate classes based on following TODOs
//Follow TODOs (if available)
/**
 * 
 * This is a JDBCCarDAO class
 * 
 * @see java.lang.Object
 * @author Abhishek
 * 
 *
 */

// TODO 2 Implement appropriate Interface
public class JDBCCarDAO implements CarDAO {
	// TODO 3 Declare a local variable datasource of type DataSource follow
	// encapsulation principle
	DataSource datasource = null;

	public JDBCCarDAO() {
		datasource = ServiceLocator.getDataSource("jdbc/VIMDataSource");
		if (datasource == null)
			throw new ServiceLocatorException("Container Service not available");
		// TODO 4 Initialize the dataSource in TODO 3 using ServiceLocator API
		// TODO 5 If any error occur in getting this service then throw
		// ServiceLocatorException
		// with error message as 'Container Service not available'
	}

	@Override
	/**
	 * This method is mapped to ADD_CAR_ACTION
	 * 
	 * @param car
	 *            a CarDTO
	 */
	public void create(CarDTO car) {
		Connection connection = null;

		String insertQuery = "insert into Car (MAKE,MODEL,MODEL_YEAR) values(?,?,?)";
		try {
			try {
				// TODO 6
				// Get a connection using datasource
				connection = datasource.getConnection();
				// Start the JDBC transaction
				connection.setAutoCommit(false);
				// Create a PreparedStatement using insertQuery
				PreparedStatement insertStat = connection.prepareStatement(insertQuery);
				// Set the parameters of the PreparedStatement
				insertStat.setString(1, car.getMake());
				insertStat.setString(2, car.getModel());
				insertStat.setString(3, car.getModelYear());
				// Invoke appropriate API of JDBC to update and commit the
				// record
				insertStat.execute();
				connection.commit();
			} catch (SQLException e) {
				// e.printStackTrace();
				if (connection != null)
					connection.rollback();
				throw e;
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting this query: " + insertQuery, e);
		}

	}

	@Override
	/**
	 * This method is mapped to DELETE_CAR_ACTION
	 * 
	 * @param ids
	 *            collection of CAR ids.
	 */
	public void delete(String[] ids) {
		Connection connection = null;
		String deleteQuery = "delete from car where id=?";

		try {
			try {
				// TODO 7
				connection = datasource.getConnection();
				// Get a connection using datasource
				connection.setAutoCommit(false);
				// Start the JDBC transaction
				// Create a PreparedStatement using deleteQuery
				PreparedStatement deleteStat = connection.prepareStatement(deleteQuery);
				for(String id:ids)
				{
					deleteStat.setInt(1, Integer.parseInt(id));
					deleteStat.execute();
				}
				// Set the parameters of the PreparedStatement
				
				// Invoke appropriate API of JDBC to update and commit the
				// record
				connection.commit();

			} catch (SQLException e) {
				if (connection != null)
					connection.rollback();

				throw e;
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting query: " + deleteQuery, e);
		}
	}

	@Override
	/**
	 * This method is mapped to EDIT_CAR_ACTION
	 * 
	 * @param car
	 *            a CarDTO
	 */
	public void update(CarDTO car) {
		// TODO Auto-generated method stub
		String updateQuery = "update car set make=?,model=?,model_year=? where id=?";
		Connection connection = null;
		
		try {
			try {
				// TODO 8
				connection = datasource.getConnection();
				connection.setAutoCommit(false);
				PreparedStatement updateStat = connection.prepareStatement(updateQuery);
				updateStat.setString(1, car.getMake());
				updateStat.setString(2, car.getModel());
				updateStat.setString(3, car.getModelYear());
				updateStat.setInt(4, car.getId());
				updateStat.execute();
				connection.commit();
				// Get a connection using datasource
				// Start the JDBC transaction
				// Create a PreparedStatement using updateQuery
				// Set the parameters of the PreparedStatement
				// Invoke appropriate API of JDBC to update and commit the
				// record
				
			} catch (SQLException e) {
				if (connection != null)
					connection.rollback();

				throw e;
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting query: " + updateQuery, e);
		}
	}

	@Override
	/**
	 * This method is mapped to VIEW_CAR_LIST_ACTION
	 * 
	 * @return List list of cars
	 */
	public List<CarDTO> findAll() {
		List<CarDTO> carList = new ArrayList<CarDTO>();
		Connection connection = null;
		String selectQuery = "select * from CAR";
		ResultSet rs = null;
		try {
			try {
				// TODO 9
				connection = datasource.getConnection();
				PreparedStatement selectStat = connection.prepareStatement(selectQuery);
				rs = selectStat.executeQuery();
				while(rs.next())
				{
					CarDTO car = new CarDTO();
					car.setMake(rs.getString("MAKE"));
					car.setModel(rs.getString("MODEL"));
					car.setModelYear(rs.getString("MODEL_YEAR"));
					car.setId(rs.getInt("ID"));
					carList.add(car);
				}
				// Get a connection using datasource
				// Don't start the JDBC transaction
				// Create a Statement using selectQuery
				// Invoke appropriate API of JDBC to fire the query
				// For iteration over the ResultSet populate carList with CarDTO

			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting query: " + selectQuery, e);
		}

		return carList;
	}

	@Override
	/**
	 * This method is utility method for finding car by id.
	 * 
	 * @param id
	 *            id of the car to be searched
	 * @return CarDTO A CarDTO
	 */
	public CarDTO findById(int id) {
		// TODO Auto-generated method stub
		String selectQuery = "select * from CAR where id=?";
		CarDTO car = new CarDTO();
		Connection connection = null;
		try {
			try {
				connection = datasource.getConnection();
				connection.setAutoCommit(true);
				PreparedStatement selectStatement = connection.prepareStatement(selectQuery);
				selectStatement.setInt(1, id);
				ResultSet result = selectStatement.executeQuery();
				if(result.next())
				{
					car.setId(result.getInt("id"));
					car.setMake(result.getString("MAKE"));
					car.setModel(result.getString("MODEL"));
					car.setModelYear(result.getString("MODEL_YEAR"));
				}
			} finally {
				if (connection != null)
					connection.close();
			}
		} catch (SQLException e) {
			throw new JDBCDaoException("SQL error while excecuting query: " + selectQuery, e);
		}

		return car;
	}

}
