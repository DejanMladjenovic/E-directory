package org.bildit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bildit.model.Contact;

/**
 * Name: ContactDaoImpl
 * 
 * @author Dejan
 */

public class ContactDaoImpl implements ContactDao {

	Connection connection = ConnectionManager.getInstance().getConnection();

	@Override
	public boolean createContact(Contact contact, String username)
			throws SQLException {
		String query = "INSERT INTO contact(firstName, lastName,  phoneNumber, address, email, userUsername) "
				+ "values(?,?,?,?,?,?)";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, contact.getFirstName());
			statement.setString(2, contact.getLastName());
			statement.setString(3, contact.getPhoneNumber());
			statement.setString(4, contact.getAddress());
			statement.setString(5, contact.getEmail());
			statement.setString(6, username);

			statement.executeUpdate();
		}
		return true;
	}

	@Override
	public List<Contact> readAllContacts(String username) throws SQLException {
		String query = "SELECT * FROM contact where userUsername=?";
		List<Contact> contacts = new ArrayList<>();
		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);

			rs = statement.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("idContact"));
				contact.setFirstName(rs.getString("firstName"));
				contact.setLastName(rs.getString("lastName"));
				contact.setPhoneNumber(rs.getString("phoneNumber"));
				contact.setAddress(rs.getString("address"));
				contact.setEmail(rs.getString("email"));
				contacts.add(contact);
			}
		}
		return contacts;
	}

	@Override
	public Contact readContact(int id) throws SQLException {
		String query = "SELECT * FROM contact WHERE idContact=?";
		Contact contact = null;
		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, id);

			rs = statement.executeQuery();
			if (rs.next()) {
				contact = new Contact();
				contact.setId(rs.getInt("idContact"));
				contact.setFirstName(rs.getString("firstName"));
				contact.setLastName(rs.getString("lastName"));
				contact.setPhoneNumber(rs.getString("phoneNumber"));
				contact.setAddress(rs.getString("address"));
				contact.setEmail(rs.getString("email"));
			}
			rs.close();
		}
		return contact;
	}

	@Override
	public List<Contact> readContactsByMatches(String match, String username)
			throws SQLException {
		String query = "SELECT * FROM contact WHERE (firstName LIKE ? OR lastName LIKE ?) AND userUsername=?";
		List<Contact> contacts = new ArrayList<>();
		ResultSet rs = null;

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, "%" + match + "%");
			statement.setString(2, "%" + match + "%");
			statement.setString(3, username);

			rs = statement.executeQuery();
			while (rs.next()) {
				Contact contact = new Contact();
				contact.setId(rs.getInt("idContact"));
				contact.setFirstName(rs.getString("firstName"));
				contact.setLastName(rs.getString("lastName"));
				contact.setPhoneNumber(rs.getString("phoneNumber"));
				contact.setAddress(rs.getString("address"));
				contact.setEmail(rs.getString("email"));
				contacts.add(contact);
			}
		}
		return contacts;
	}

	@Override
	public boolean updateContact(Contact contact) throws SQLException {
		String query = "UPDATE contact SET firstName = ?, lastName = ?, phoneNumber = ?,"
				+ "address = ?, email = ? WHERE idContact = ?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, contact.getFirstName());
			statement.setString(2, contact.getLastName());
			statement.setString(3, contact.getPhoneNumber());
			statement.setString(4, contact.getAddress());
			statement.setString(5, contact.getEmail());
			statement.setInt(6, contact.getIdContact());

			statement.executeUpdate();
		}
		return true;
	}

	@Override
	public boolean deleteContact(Contact contact) throws SQLException {

		String query = "DELETE FROM contact WHERE idContact=?";

		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, contact.getIdContact());

			statement.executeUpdate();
		}
		return true;
	}
}
