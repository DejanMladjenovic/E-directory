package org.bildit.dao.user;

import java.sql.SQLException;
import java.util.List;

/**
 * Name: UserDao
 * 
 * @author Dejan
 */

import org.bildit.model.User;

public interface UserDao {

	boolean createUser(User user) throws SQLException;

	User readUser(String username) throws SQLException;

	List<User> readAllUsers() throws SQLException;
}
