package org.bildit.bo.user;

import java.sql.SQLException;

import org.bildit.dao.user.UserDaoImpl;
import org.bildit.model.User;

/**
 * name: UserBoImpl
 * 
 * @author Dejan
 *
 */

public class UserBoImpl implements UserBo{
	
	UserDaoImpl dao = new UserDaoImpl();

	@Override
	public boolean createUser(User user)  {
		
		if(user != null){
			try {
				dao.createUser(user);
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;		
		} else
			return false;
	}

	@Override
	public User readUser(String username) {
		
		User user = null;
		
		try{
			user = dao.readUser(username);
		} catch (SQLException | NullPointerException e) {
			e.printStackTrace();
		}
		return user;
	}
}
