package Service;

import model.User;

public class UserService {
	public boolean login(String username, String password) {
		User user = getUser(username);
		
		if(user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	private User getUser(String username) {
//		username is used to find user from data
//		currently using default user
	   User user = new User("test", "password");
	   return user;
	}
}
