package com.cg;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.xml.ws.RespectBinding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("UserRepository")
public class UserDAO implements UserDaoI {

	DataSource datasource;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	@Qualifier("UserDataSource")
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(datasource);
	}

	public void create(UserDTO user) {

		BeanPropertySqlParameterSource sqlParameterSource;
		sqlParameterSource = new BeanPropertySqlParameterSource(user);
		String insertQuery = "insert into user (username,password,email, birthdate, profession) values(:username,:password,:email,:birthDate,:profession)";
		namedParameterJdbcTemplate.update(insertQuery, sqlParameterSource);
	}
}