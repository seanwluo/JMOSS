package Service;

import fileService.FileService;
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
		
//		Read data user data from file
		FileService fService = new FileService("User.txt");
		String userData = fService.read();
		String[] data = userData.split(",");
		String usrname = data[0].trim();
		String password = data[1].trim();

		User user = new User(usrname, password);
		return user;
	}
}
