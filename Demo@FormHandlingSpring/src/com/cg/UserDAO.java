package com.cg;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
@Repository("UserRepository")
public class UserDAO implements UserDaoI {
	@Autowired
	@Qualifier("UserDataSource")
	DataSource datasource;

	/*public UserDAO(DataSource datasource) {
		this.datasource = datasource;
		if (datasource == null)
			throw new RuntimeException("Datasource null");
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
		if (datasource == null)
			throw new RuntimeException("Datasource null");
	}*/

	public void create(UserDTO user) {
		Connection connection = null;

		String insertQuery = "insert into user (username,password,email, birthdate, profession) values(?,?,?,?,?)";
		try {
			try {
				connection = datasource.getConnection();
				connection.setAutoCommit(false);
				PreparedStatement insertStat = connection.prepareStatement(insertQuery);
				insertStat.setString(1, user.getUsername());
				insertStat.setString(2, user.getPassword());
				insertStat.setString(3, user.getEmail());
				insertStat.setDate(4, new Date(user.getBirthDate().getTime()));
				insertStat.setString(5, user.getProfession());
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
			throw new RuntimeException("SQL error while excecuting this query: " + insertQuery, e);
		}
	}
}