package application.composite;

import java.util.ArrayList;
import java.util.List;

import application.admin.Admin;
import application.observer.*;

public class User implements Component, Subject, Observer{

	private List<Observer> observers;
	private String username;
	private List<String> followers;
	private List<String> followings;
	private List<String> tweets;
	private static final boolean isLeaf = true;
	
	public User(String username) {
		this.username = username;
		followers = new ArrayList<String>();
		followings = new ArrayList<String>();
		tweets = new ArrayList<String>();
		observers = new ArrayList<Observer>();
	}
	
	public String getId() {
		return username;
	}
	
	public void addFollower(String userId) {

		followers.add(userId);
	}
	
	public void addFollowing(String userId) {
		followings.add(userId);
		for(User user: Admin.getInstance().getUserList()) {
			if(user.getId().equals(userId)) {
				user.addFollower(this.getId());
				user.attach(this);
				System.out.println("Follower for=" + user.getId() + "follower-" + user.getFollowers().size() + "following-" + user.getFollowings().size());
				System.out.println("Number of " + user.observers.size());
			}
		}
		
	}
	
	public void addTweet(String text) {
		tweets.add(text);
	}
	
	public boolean isLeaf() {
		return isLeaf;
	}

	public List<String> getFollowers(){
		return followers;
	}
	
	public List<String> getFollowings(){
		return followings;
	}
	
	public List<String> getTweets(){
		return tweets;
	}
	
	/******************************************************/
	public void addComposite(Group group) {}

	public void addLeaf(User user) {}

	/*****************************************************/
	
	@Override
	public void attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers(String text) {
		for(Observer observer: observers) {
			observer.update(this, text);
		}
	}
	
	@Override
	public void update(Subject subject, String text) {
		if(subject instanceof User ) {
			this.addTweet(text);
		}
	}
	
	
}
