package org.bildit.bo.user;

import org.bildit.model.User;

/**
 * name: UserBo
 * 
 * @author Dejan
 *
 */

public interface UserBo {

	boolean createUser(User user);

	boolean readUser(String username, String password);

}
