package com.hcl.TestProject.DAO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
}
