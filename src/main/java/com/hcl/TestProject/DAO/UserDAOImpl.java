package com.hcl.TestProject.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.hcl.TestProject.service.User;

@Repository
public class UserDAOImpl implements UserDAO {

	Logger logger = LoggerFactory.getLogger(UserDAOImpl.class);
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	
	@Override
	public String insertUser(User user) {
		logger.info("User Details {}", new Object[] {user.getId(), user.getUserName(), user.getCity(), user.getEmail()});
		int x = 5555;
		String sql = "insert into at_user(id, username,city,email) values('"+user.getId()+"', '"+user.getUserName()+"', '"+user.getCity()+"', '"+user.getEmail()+"')";
		try {
			x = jdbcTemplate.update(sql);
		} catch (Exception e) {
			logger.error("Exception ", e);
		}
		return Integer.toString(x);
		
	}

	@Override
	public List<User> getUser(String userName) {
		logger.info("Retrieving the details of the user: {}", userName);
		List<User> user1 = new ArrayList<>();
		try {
			user1 = jdbcTemplate.query("select id, username, city, email from at_user where username='"+userName+"'", GETUSERROWS);
		} catch (Exception e) {
			logger.error("Exception raised while retrieving the data", e);
		}
		return user1;
	}
	
	RowMapper<User> GETUSERROWS = new RowMapper<User>() {
		
		@Override
		public User mapRow(ResultSet rset, int arg1) throws SQLException {
			User user = new User();
			user.setUserName(rset.getString("username"));
			user.setCity(rset.getString("city"));
			user.setEmail(rset.getString("email"));
			user.setId(rset.getString("id"));
			return user;
		}
	};

	@Override
	public List<User> getUsers() {
		logger.info("Retrieving the details of the users");
		List<User> user1 = new ArrayList<>();
		try {
			user1 = jdbcTemplate.query("select id, username, city, email from at_user", GETUSERROWS);
		} catch (Exception e) {
			logger.error("Exception raised while retrieving the data", e);
		}
		return user1;
	}
}
