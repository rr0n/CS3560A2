package application.composite;

import java.util.Arrays;
import java.util.List;

public class User implements Component{

	private String username;
	private List<String> followers;
	private List<String> followings;
	private List<String> messages;
	private static final boolean isLeaf = true;
	
	public User(String username) {
		this.username = username;
		followers = Arrays.asList();
		followings = Arrays.asList();
		messages = Arrays.asList();
	}
	
	public String getId() {
		return username;
	}
	
	public void addFollower(String userId) {
		followers.add(userId);
	}
	
	public void addFollowing(String userId) {
		followings.add(userId);
	}
	
	public boolean isLeaf() {
		return isLeaf;
	}
}
