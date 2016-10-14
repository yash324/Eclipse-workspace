package com.cg;

import javax.sql.DataSource;

public interface UserDaoI {
//	public void setDatasource(DataSource datasource);
	public void create(UserDTO user);
}
