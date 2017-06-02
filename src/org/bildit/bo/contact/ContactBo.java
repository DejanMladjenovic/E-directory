package org.bildit.bo.contact;

import java.util.List;

import org.bildit.model.Contact;

/**
 * name: ContactBo
 * 
 * @author Dejan
 *
 */

public interface ContactBo {
	
	boolean createContact(Contact contact, String username);
	
	List<Contact> readAll(String username);
	
	boolean deleteContact(Contact contact);
	
	Contact readContact(int id);
	
	List<Contact> readContactsByMatches(String match, String username);
	
	boolean updateContact(Contact contact);
}
