/**
 * 
 */
package com.example.venu.springlearning.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author venugopal
 *
 */
@Component
public class UserDAOService {

	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(1,"Venu", new Date()));
		users.add(new User(2,"Balan", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User createUser(User user) {
		user.setId(users.size()+1);
		users.add(user);
		return user;
	}
	
	public User getUser(int id) {
		for(User user:users) {
			if(user.getId()==id)
				return user;
		}
		return null;
	}
	
	public User deleteUser(int id) {
		Iterator<User> itUser = users.iterator();
		while (itUser.hasNext()) {
			User user = itUser.next();
			if(user.getId()==id) {
				itUser.remove();
				return user;
			}
		}
		return null;
	}
}
