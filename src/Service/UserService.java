package Service;

import java.util.ArrayList;
import java.util.List;

import fileService.FileService;
import model.User;

public class UserService {
	
	@SuppressWarnings("null")
	public boolean login(String username, String password) {
		User user = getUser(username);
		
		if(user == null)
		{
			return false;
		}
		
		if(user.getPassword().equals(password)) {
			return true;
		} else {
			return false;
		}
	}
	
	private User getUser(String username) {
//		username is used to find user from data
//		currently using default user
		
//		Read data user data from file
		FileService fService = new FileService("User.txt");
		List<String> users = fService.read();
		for(String userData: users) {
			String[] data = userData.split(",");
			String usrname = data[0].trim();
			String password = data[1].trim();

			if (usrname.equals(username)) {
				User user = new User(usrname, password);
				return user;
			}
		}
		
		return null;
	}
}
