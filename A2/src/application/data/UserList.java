package application.data;

import java.util.Arrays;
import java.util.List;

import application.composite.User;

public class UserList {
	
	private List<User> users;
	
	public UserList() {
		users = Arrays.asList();
	}
	
	public void addUsers(User user) {
		users.add(user);
	}
	
	public int getTotal() {
		return users.size();
	}
}
