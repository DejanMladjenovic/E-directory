package org.bildit.bo.contact;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bildit.dao.contact.ContactDaoImpl;
import org.bildit.model.Contact;

/**
 * name: ContactBo
 * 
 * @author Dejan
 *
 */

public class ContactBoImpl implements ContactBo {
	
	ContactDaoImpl dao = new ContactDaoImpl();

	
	@Override
	public boolean createContact(Contact contact, String username) {
		
		if(contact != null) {
			try{
				dao.createContact(contact, username);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} else
			return false;
	}

	@Override
	public List<Contact> readAll(String username) {
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		try{
			contacts = dao.readAllContacts(username);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return contacts;
	}

	@Override
	public boolean deleteContact(Contact contact) {
		
		if(contact != null){
			try{
				dao.deleteContact(contact);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} else
			return false;
	}

	@Override
	public Contact readContact(int id) {
		
		Contact contact = null;
		
		if(id >= 0){
			try{
				contact = dao.readContact(id);
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
			return contact;
		} else
			return null;
	}
	
	@Override
	public List<Contact> readContactsByMatches(String match, String username) {
		
		List<Contact> contacts = new ArrayList<Contact>();
		
		try{
			contacts = dao.readContactsByMatches(match, username);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return contacts;
	}
	
	@Override
	public boolean updateContact(Contact contact) {
		
		if(contact != null){
			try{
				dao.updateContact(contact);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		} else
			return false;
	}
}
