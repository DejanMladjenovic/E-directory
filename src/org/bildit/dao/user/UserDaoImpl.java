package org.bildit.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.bildit.dao.ConnectionManager;
import org.bildit.model.User;

/**
 * Name: UserDaoImpl
 * 
 * @author Dejan
 */

public class UserDaoImpl implements UserDao {

	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean createUser(User user) throws SQLException {
		String query = "INSERT INTO user(username, password, email) VALUES (?,?,?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getEmail());

			statement.executeUpdate();
			return true;
		}
	}

	@Override
	public User readUser(String username) throws SQLException {
		String query = "SELECT * FROM user WHERE username=?";
		User user = null;
		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);

			rs = statement.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("username"),
						rs.getString("password"), rs.getString("email"));
			}
			rs.close();

		}
		return user;
	}

	@Override
	public List<User> readAllUsers() throws SQLException {
		String query = "SELECT * FROM user";
		List<User> allUsers = new ArrayList<>();
		ResultSet rs = null;

		try (Statement statement = connection.createStatement()) {

			rs = statement.executeQuery(query);
			while (rs.next()) {
				allUsers.add(new User(rs.getString("username"), rs
						.getString("password"), rs.getString("email")));
			}
			rs.close();
		}
		return allUsers;
	}

}
