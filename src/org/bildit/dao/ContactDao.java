package org.bildit.dao;

import java.sql.SQLException;
import java.util.List;

import org.bildit.model.Contact;

/**
 * Name: ContactDao
 * 
 * @author Dejan
 */

public interface ContactDao {

	boolean createContact(Contact contact, String username) throws SQLException;

	List<Contact> readAllContacts(String username) throws SQLException;

	Contact readContact(int id) throws SQLException;

	List<Contact> readContactsByMatches(String match, String username)
			throws SQLException;

	boolean updateContact(Contact contact) throws SQLException;

	boolean deleteContact(Contact contact) throws SQLException;
}
